using System;
using System.Threading.Tasks;

using Microsoft.Bot.Connector;
using Microsoft.Bot.Builder.Dialogs;
using System.Net.Http;
using GreatWall.Dialogs;
using System.Collections.Generic;

namespace GreatWall
{
    [Serializable] // ����ȭ ����

    public class RootDialog : IDialog<object>
    {
        string WelcomeMessage = "�ȳ��ϼ��� �����强 ���Դϴ�. 1.�ֹ� 2.FAQ �߿� �����ϼ���";

        public async Task StartAsync(IDialogContext context)
        {
            context.Wait(MessageReceivedAsync);
        }

        private async Task MessageReceivedAsync(IDialogContext context, IAwaitable<object> result)
        {
            await context.PostAsync(WelcomeMessage);

            var message = context.MakeMessage();

            var actions = new List<CardAction>();

            actions.Add(new CardAction() { Title = "1.�ֹ�", Value = "1", Type = ActionTypes.ImBack });
            actions.Add(new CardAction() { Title = "2.FAQ", Value = "2", Type = ActionTypes.ImBack });


            message.Attachments.Add(
                new HeroCard
                {
                    Title = "���ϴ� ����� �����ϼ���",
                    Buttons = actions
                }.ToAttachment()
            );

            await context.PostAsync(message);

            context.Wait(SendWelcomeMessageAsync);
        }
        private async Task SendWelcomeMessageAsync(IDialogContext context, IAwaitable<object> result)
        {
            var activity = await result as Activity;
            string selected = activity.Text.Trim();

            if (selected == "1")
            {
                await context.PostAsync("���� �ֹ� �޴� �Դϴ�. ���Ͻô� ������ �Է��� �ֽʽÿ�.");
                context.Call(new OrderDialog(), DialogResumeAfter);
            }
            else if (selected == "2")
            {
                await context.PostAsync("FAQ ���� �Դϴ�. ������ �Է��� �ֽʽÿ�.");
                context.Call(new FAQDialog(), DialogResumeAfter);

            }
            else
            {
                await context.PostAsync("�߸� �����ϼ̽��ϴ�. �ٽ� ������ �ֽʽÿ�");
                context.Wait(SendWelcomeMessageAsync);
            }
        }

        private async Task DialogResumeAfter(IDialogContext context, IAwaitable<string> result)
        {
            try
            {
                string message = await result;

                await this.MessageReceivedAsync(context, null);
            }
            catch (TooManyAttemptsException)
            {
                await context.PostAsync("������ ������ϴ�. �˼��մϴ�.");
            }
        }

    }
}