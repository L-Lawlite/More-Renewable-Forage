package net.lawliet.moreRenewableFlora.data_generator;

import com.mojang.logging.LogUtils;
import net.lawliet.moreRenewableFlora.MoreRenewableFlora;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.slf4j.Logger;

@EventBusSubscriber(modid = MoreRenewableFlora.MODID)
public class DataGeneratorServer {
    private static final Logger LOGGER = LogUtils.getLogger();

    @SubscribeEvent
    public static void generate(GatherDataEvent.Server event) {
        LOGGER.info("Generating Server Files...");
    }
}
