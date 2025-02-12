package net.badbird5907;

import static net.dv8tion.jda.api.JDABuilder.createDefault;

import javax.security.auth.login.LoginException;

import org.jetbrains.annotations.NotNull;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Main extends ListenerAdapter {
	public static void main(String[] args) {
		try {
			JDA jda = createDefault("<Token here>").build();
			jda.addEventListener(new ListenerAdapter() {
				@Override
				public void onMessageReceived(@NotNull MessageReceivedEvent event) {
					if (event.getMessage().getContentRaw().equalsIgnoreCase("!test"))
						event.getMessage().reply(new EmbedBuilder().setTitle("Test").setDescription("Hi").build())
								.queue();
					else if (event.getMessage().getContentRaw().equalsIgnoreCase("!full"))
						event.getMessage()
								.reply(new EmbedBuilder().setTitle(" - Test - Full embed - Hello World! - Placeholder")
										.setDescription("Hello World!").addField("Test", "Test123", true).build())
								.queue();
				}
			});
		} catch (LoginException e) {
			e.printStackTrace();
		}
	}
}
