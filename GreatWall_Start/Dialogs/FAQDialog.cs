using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

using System.Threading.Tasks;
using Microsoft.Bot.Connector;
using Microsoft.Bot.Builder.Dialogs;
using System.Threading;
using QnAMakerDialog.Models;
using QnAMakerDialog;


namespace GreatWall.Dialogs
{
    [Serializable]
    [QnAMakerService("https://labuser1qna.azurewebsites.net/qnamaker", "dd44a16d-94a0-457f-a0d7-9cfc47117b85", "859d0377-6238-4183-b70f-a25165d1c9f5", MaxAnswers = 5)]
    public class FAQDialog : QnAMakerDialog<string>
    {
        public override async Task NoMatchHandler(IDialogContext context, string originalQueryText)
        {
            await context.PostAsync($"Sorry, I couldn't find an answer for '{originalQueryText}'.");
            context.Wait(MessageReceived);
        }

        public override async Task DefaultMatchHandler(IDialogContext context, string originalQueryText, QnAMakerResult result)
        {
            if (originalQueryText == "그만")
            {
                context.Done("");
                return;
            }

            await context.PostAsync(result.Answers.First().Answer);

            context.Wait(MessageReceived);
        }

        [QnAMakerResponseHandler(0.5)]
        public async Task LowScoreHandler(IDialogContext context, string originalQueryText, QnAMakerResult result)
        {
            var messageActivity = ProcessResultAndCreateMessageActivity(context, ref result);
            messageActivity.Text = $"I found an answer that might help...{result.Answers.First().Answer}.";
            await context.PostAsync(messageActivity);

            context.Wait(MessageReceived);
        }
    }
}