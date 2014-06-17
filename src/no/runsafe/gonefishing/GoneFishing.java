package no.runsafe.gonefishing;

import no.runsafe.framework.RunsafeConfigurablePlugin;
import no.runsafe.framework.api.command.Command;
import no.runsafe.framework.features.Commands;
import no.runsafe.framework.features.Events;
import no.runsafe.framework.tools.nms.EntityRegister;
import no.runsafe.gonefishing.commands.MakeMount;
import no.runsafe.gonefishing.commands.StartEvent;
import no.runsafe.gonefishing.commands.StopEvent;
import no.runsafe.gonefishing.scavenger.*;

public class GoneFishing extends RunsafeConfigurablePlugin
{
	@Override
	protected void pluginSetup()
	{
		// Framework features
		addComponent(Commands.class);
		addComponent(Events.class);

		addComponent(MountHandler.class);

		addComponent(EventConfig.class);
		addComponent(EventHandler.class);

		// Custom fishing loot
		addComponent(LootConfig.class);
		addComponent(ChordBook.class);
		addComponent(FlintBoardingPass.class);
		addComponent(FlintGold.class);
		addComponent(FlintTicket.class);
		addComponent(FiggleShirt.class);
		addComponent(DeadTorch.class);
		addComponent(SeaWeed.class);
		addComponent(LootHandler.class);

		// Register the squid mount.
		EntityRegister.registerEntity(SquidMount.class, "SquidMount", 94);

		Command fishingCommand = new Command("gonefishing", "Fishing tournament related commands", null);
		addComponent(fishingCommand);

		fishingCommand.addSubCommand(getInstance(StartEvent.class));
		fishingCommand.addSubCommand(getInstance(StopEvent.class));
		fishingCommand.addSubCommand(getInstance(MakeMount.class));
	}
}
