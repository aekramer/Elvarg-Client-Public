package net.runelite.client.plugins.hd.data.materials;

import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;
import net.runelite.client.plugins.hd.HdPlugin;
import net.runelite.client.plugins.hd.HdPluginConfig;
import net.runelite.client.plugins.hd.data.WaterType;
import net.runelite.client.plugins.hd.data.environments.Area;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

@Setter
@Accessors(fluent = true)
class TileOverrideBuilder<T> {
    public Integer[] ids = null;
    public Area area = Area.ALL;
    public GroundMaterial groundMaterial = GroundMaterial.NONE;
    public WaterType waterType = WaterType.NONE;
    public boolean blended = true;
    public boolean blendedAsOpposite = false;
    public int hue = -1;
    public int shiftHue = 0;
    public int saturation = -1;
    public int shiftSaturation = 0;
    public int lightness = -1;
    public int shiftLightness = 0;
    public T replacement;
    public Function<HdPlugin, Boolean> replacementCondition = c -> false;

    TileOverrideBuilder<T> apply(Consumer<TileOverrideBuilder<T>> consumer) {
        consumer.accept(this);
        return this;
    }

    TileOverrideBuilder<T> ids(Integer... ids) {
        if (this.ids != null && this.ids.length > 0)
            throw new IllegalStateException(
                "Attempted to overwrite IDs " + Arrays.toString(this.ids) +
                " with IDs " + Arrays.toString(ids) +
                " in " + TileOverrideBuilder.class.getSimpleName() + "." +
                "This is likely a mistake.");
        this.ids = ids;
        return this;
    }

    TileOverrideBuilder<T> waterType(WaterType waterType) {
        this.waterType = waterType;
        this.groundMaterial = GroundMaterial.NONE;
        return this;
    }

    TileOverrideBuilder<T> replaceWithIf(@NonNull T replacement, @NonNull Function<HdPlugin, Boolean> condition) {
        this.replacement = replacement;
        this.replacementCondition = condition;
        return this;
    }
}
