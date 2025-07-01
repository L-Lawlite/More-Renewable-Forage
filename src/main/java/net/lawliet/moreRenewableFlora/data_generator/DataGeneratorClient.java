package net.lawliet.moreRenewableFlora.data_generator;

import com.mojang.logging.LogUtils;
import net.lawliet.moreRenewableFlora.MoreRenewableFlora;
import net.lawliet.moreRenewableFlora.data_generator.tags.block.BlockTagGenerator;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.slf4j.Logger;

@EventBusSubscriber(modid = MoreRenewableFlora.MODID)
public class DataGeneratorClient {
    private static final Logger LOGGER = LogUtils.getLogger();



    @SubscribeEvent
    public static void generate(GatherDataEvent.Client event) {
        LOGGER.info("Generating Client Files...");

        event.createProvider(BlockTagGenerator::new);

    }
}
