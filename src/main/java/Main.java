import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class DiscordBot extends ListenerAdapter {

    private JDA jda;

    public DiscordBot(String token) throws LoginException {
        JDABuilder builder = new JDABuilder(token);
        builder.addEventListeners(this);
        jda = builder.build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message message = event.getMessage();
        if (message.().size() > 0) {
            message.().get(0).getButtons().get(0).click();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String token = args[0];
        DiscordBot bot = new DiscordBot(token);
        bot.jda.awaitReady();
    }
}