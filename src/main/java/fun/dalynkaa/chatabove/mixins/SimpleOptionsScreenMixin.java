package fun.dalynkaa.chatabove.mixins;

import fun.dalynkaa.chatabove.ChatHeads;
import fun.dalynkaa.chatabove.ChatHeads;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.ChatOptionsScreen;
import net.minecraft.client.gui.screen.option.SimpleOptionsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.text.MutableText;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Supplier;

@Mixin(SimpleOptionsScreen.class)
public class SimpleOptionsScreenMixin extends Screen {


    protected SimpleOptionsScreenMixin(Text title) {
        super(title);
    }

    @Inject(at = @At("RETURN"), method = "init")
    public void init(CallbackInfo ci) {
        if (((SimpleOptionsScreen) (Object) this) instanceof ChatOptionsScreen) {

            this.addDrawableChild(
                    ButtonWidget.builder(
                            Text.translatable("text.autoconfig.chatheads.title")
                            , button -> client.setScreen(ChatHeads.getConfigScreen(((SimpleOptionsScreen) (Object) this)))
                    ).dimensions(
                            20,
                            this.height - 27,
                            width / 6,
                            20
                            ).build()
            );


        }
    }


}
