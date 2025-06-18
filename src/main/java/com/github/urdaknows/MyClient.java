package com.github.urdaknows;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;

public class MyClient implements ModInitializer {
	public static final String MOD_ID = "myclient";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	
	private static MinecraftServer SERVER = null;

	@Override
	public void onInitialize() {
		ServerLifecycleEvents.SERVER_STARTED.register(server -> SERVER = server);
		
		LOGGER.info("Hello Fabric world!");
	}
}