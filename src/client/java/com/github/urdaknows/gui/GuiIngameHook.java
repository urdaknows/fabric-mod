package com.github.urdaknows.gui;

import java.util.List;

import com.github.urdaknows.module.ModuleClient;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.text.Text;

public class GuiIngameHook implements HudRenderCallback {
	
    private final List<ModuleClient> moduleClients;
    
    public GuiIngameHook(List<ModuleClient> moduleClients) {
        this.moduleClients = moduleClients;
    }

	@Override
	public void onHudRender(DrawContext drawContext, RenderTickCounter tickCounter) {
		MinecraftClient client = MinecraftClient.getInstance();
		if (client.player == null || client.options.hudHidden) return;

		int y = 10;
        for (ModuleClient moduleClient : moduleClients) {
            if (moduleClient.isEnabled()) {
                String text = moduleClient.getName();
                drawContext.drawTextWithShadow(client.textRenderer, Text.literal(text), 10, y, 0x00FF00);
                y += 10;
            }
        }
		
	}

}
