using System;
using System.Threading.Tasks;

using Microsoft.Bot.Connector;
using Microsoft.Bot.Builder.Dialogs;
using System.Net.Http;


namespace GreatWall
{
    [Serializable] // 직렬화 가능
    public class RootDialog : IDialog<object>
    {

        public async Task StartAsync(IDialogContext context)
        {
            context.Wait(MessageReceivedAsync);
        }

        public async Task MessageReceivedAsync(IDialogContext context, IAwaitable<IMessageActivity> argument)
        {
            await context.PostAsync("안녕하세요. 신속배달 만리장성 봇 입니다. 주문하려는 메뉴를 입력하세요.");
            
            context.Wait(SendWelcomeMeassageAsync);
        }

        public async Task SendWelcomeMeassageAsync(IDialogContext context, IAwaitable<IMessageActivity> argument)
        {
            var activity = await argument as Activity;

            string message = string.Format("{0}을 주문하셨습니다. 감사합니다.", activity.Text);
            await context.PostAsync(message);

           context.Wait(MessageReceivedAsync);

        }
    }
}