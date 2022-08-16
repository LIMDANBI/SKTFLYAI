using System;
using System.Threading.Tasks;

using Microsoft.Bot.Connector;
using Microsoft.Bot.Builder.Dialogs;
using System.Net.Http;


namespace GreatWall
{
    [Serializable] // ����ȭ ����
    public class RootDialog : IDialog<object>
    {

        public async Task StartAsync(IDialogContext context)
        {
            context.Wait(MessageReceivedAsync);
        }

        public async Task MessageReceivedAsync(IDialogContext context, IAwaitable<IMessageActivity> argument)
        {
            await context.PostAsync("�ȳ��ϼ���. �żӹ�� �����强 �� �Դϴ�. �ֹ��Ϸ��� �޴��� �Է��ϼ���.");
            
            context.Wait(SendWelcomeMeassageAsync);
        }

        public async Task SendWelcomeMeassageAsync(IDialogContext context, IAwaitable<IMessageActivity> argument)
        {
            var activity = await argument as Activity;

            string message = string.Format("{0}�� �ֹ��ϼ̽��ϴ�. �����մϴ�.", activity.Text);
            await context.PostAsync(message);

           context.Wait(MessageReceivedAsync);

        }
    }
}