/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IllIIlIIllIIlIlllIlIlIlllIIIlIIlllIIIlIllIIIlIllIIIllIIlIIIllIIIllIIIlllIlllIllIllIllIIIlIIIllIlIlllIIllIlllIIIllIlIIlIIlIlIlIIllIllIlllIIllIlIIlIIIlllIIllIIIlIIIllIIIlllIIIllIlllIIlIlIIlIIllIIIlllIllIlIIIlIlIIlIIIlllIIIlll
 *  me.snow.aclient.core.setting.superblaubeere27obfuscator.IllIlIIlIIlllIllIIllIIIlllIlllIllIIIllIIllIIlllIllIlllIIllIlIIlIlIIllIlIIllIIIlllIIIlIIllIllIIlIIlIIIllIIIllIIlllIIllIIlIIIlIIlIlllIlllIlllIllIIlllIIlIlllIIIlIIIllIlllIIllIllIIllIIlIIIllIIllIlIlIlllIlIIlIIllIllIIllIIIllIl
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.eventhandler.Event
 */
package me.snow.aclient.core.setting;

import java.util.function.Predicate;
import me.snow.aclient.core.setting.Bind;
import me.snow.aclient.core.setting.EnumConverter;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IllIIlIIllIIlIlllIlIlIlllIIIlIIlllIIIlIllIIIlIllIIIllIIlIIIllIIIllIIIlllIlllIllIllIllIIIlIIIllIlIlllIIllIlllIIIllIlIIlIIlIlIlIIllIllIlllIIllIlIIlIIIlllIIllIIIlIIIllIIIlllIIIllIlllIIlIlIIlIIllIIIlllIllIlIIIlIlIIlIIIlllIIIlll;
import me.snow.aclient.core.setting.superblaubeere27obfuscator.IllIlIIlIIlllIllIIllIIIlllIlllIllIIIllIIllIIlllIllIlllIIllIlIIlIlIIllIlIIllIIIlllIIIlIIllIllIIlIIlIIIllIIIllIIlllIIllIIlIIIlIIlIlllIlllIlllIllIIlllIIlIlllIIIlIIIllIlllIIllIllIIllIIlIIIllIIllIlIlIlllIlIIlIIllIllIIllIIIllIl;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.Event;

public class Setting<T> {
    private final String name;
    private final T defaultValue;
    T value;
    private T plannedValue;
    private T min;
    private T max;
    private boolean hasRestriction;
    private boolean shouldRenderStringName;
    private Predicate<T> visibility;
    private String description;
    private IllIIlIIllIIlIlllIlIlIlllIIIlIIlllIIIlIllIIIlIllIIIllIIlIIIllIIIllIIIlllIlllIllIllIllIIIlIIIllIlIlllIIllIlllIIIllIlIIlIIlIlIlIIllIllIlllIIllIlIIlIIIlllIIllIIIlIIIllIIIlllIIIllIlllIIlIlIIlIIllIIIlllIllIlIIIlIlIIlIIIlllIIIlll feature;

    public Setting(String name, T defaultValue) {
        this.name = name;
        this.defaultValue = defaultValue;
        this.value = defaultValue;
        this.plannedValue = defaultValue;
        this.description = "";
    }

    public Setting(String name, T defaultValue, String description) {
        this.name = name;
        this.defaultValue = defaultValue;
        this.value = defaultValue;
        this.plannedValue = defaultValue;
        this.description = description;
    }

    public Setting(String name, T defaultValue, T min, T max, String description) {
        this.name = name;
        this.defaultValue = defaultValue;
        this.value = defaultValue;
        this.min = min;
        this.max = max;
        this.plannedValue = defaultValue;
        this.description = description;
        this.hasRestriction = true;
    }

    public Setting(String name, T defaultValue, T min, T max) {
        this.name = name;
        this.defaultValue = defaultValue;
        this.value = defaultValue;
        this.min = min;
        this.max = max;
        this.plannedValue = defaultValue;
        this.description = "";
        this.hasRestriction = true;
    }

    public Setting(String name, T defaultValue, T min, T max, Predicate<T> visibility, String description) {
        this.name = name;
        this.defaultValue = defaultValue;
        this.value = defaultValue;
        this.min = min;
        this.max = max;
        this.plannedValue = defaultValue;
        this.visibility = visibility;
        this.description = description;
        this.hasRestriction = true;
    }

    public Setting(String name, T defaultValue, T min, T max, Predicate<T> visibility) {
        this.name = name;
        this.defaultValue = defaultValue;
        this.value = defaultValue;
        this.min = min;
        this.max = max;
        this.plannedValue = defaultValue;
        this.visibility = visibility;
        this.description = "";
        this.hasRestriction = true;
    }

    public Setting(String name, T defaultValue, Predicate<T> visibility) {
        this.name = name;
        this.defaultValue = defaultValue;
        this.value = defaultValue;
        this.visibility = visibility;
        this.plannedValue = defaultValue;
    }

    public String getName() {
        return this.name;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.setPlannedValue(value);
        if (this.hasRestriction) {
            if (((Number)this.min).floatValue() > ((Number)value).floatValue()) {
                this.setPlannedValue(this.min);
            }
            if (((Number)this.max).floatValue() < ((Number)value).floatValue()) {
                this.setPlannedValue(this.max);
            }
        }
        IllIlIIlIIlllIllIIllIIIlllIlllIllIIIllIIllIIlllIllIlllIIllIlIIlIlIIllIlIIllIIIlllIIIlIIllIllIIlIIlIIIllIIIllIIlllIIllIIlIIIlIIlIlllIlllIlllIllIIlllIIlIlllIIIlIIIllIlllIIllIllIIllIIlIIIllIIllIlIlIlllIlIIlIIllIllIIllIIIllIl event = new IllIlIIlIIlllIllIIllIIIlllIlllIllIIIllIIllIIlllIllIlllIIllIlIIlIlIIllIlIIllIIIlllIIIlIIllIllIIlIIlIIIllIIIllIIlllIIllIIlIIIlIIlIlllIlllIlllIllIIlllIIlIlllIIIlIIIllIlllIIllIllIIllIIlIIIllIIllIlIlIlllIlIIlIIllIllIIllIIIllIl(this);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (!event.isCanceled()) {
            this.value = this.plannedValue;
        } else {
            this.plannedValue = this.value;
        }
    }

    public T getPlannedValue() {
        return this.plannedValue;
    }

    public void setPlannedValue(T value) {
        this.plannedValue = value;
    }

    public T getMin() {
        return this.min;
    }

    public void setMin(T min) {
        this.min = min;
    }

    public T getMax() {
        return this.max;
    }

    public void setMax(T max) {
        this.max = max;
    }

    public void setValueNoEvent(T value) {
        this.setPlannedValue(value);
        if (this.hasRestriction) {
            if (((Number)this.min).floatValue() > ((Number)value).floatValue()) {
                this.setPlannedValue(this.min);
            }
            if (((Number)this.max).floatValue() < ((Number)value).floatValue()) {
                this.setPlannedValue(this.max);
            }
        }
        this.value = this.plannedValue;
    }

    public IllIIlIIllIIlIlllIlIlIlllIIIlIIlllIIIlIllIIIlIllIIIllIIlIIIllIIIllIIIlllIlllIllIllIllIIIlIIIllIlIlllIIllIlllIIIllIlIIlIIlIlIlIIllIllIlllIIllIlIIlIIIlllIIllIIIlIIIllIIIlllIIIllIlllIIlIlIIlIIllIIIlllIllIlIIIlIlIIlIIIlllIIIlll getFeature() {
        return this.feature;
    }

    public void setFeature(IllIIlIIllIIlIlllIlIlIlllIIIlIIlllIIIlIllIIIlIllIIIllIIlIIIllIIIllIIIlllIlllIllIllIllIIIlIIIllIlIlllIIllIlllIIIllIlIIlIIlIlIlIIllIllIlllIIllIlIIlIIIlllIIllIIIlIIIllIIIlllIIIllIlllIIlIlIIlIIllIIIlllIllIlIIIlIlIIlIIIlllIIIlll feature) {
        this.feature = feature;
    }

    public int getEnum(String input) {
        for (int i2 = 0; i2 < this.value.getClass().getEnumConstants().length; ++i2) {
            Enum e2 = (Enum)this.value.getClass().getEnumConstants()[i2];
            if (!e2.name().equalsIgnoreCase(input)) continue;
            return i2;
        }
        return -1;
    }

    public void setEnumValue(String value) {
        for (Enum e2 : (Enum[])((Enum)this.value).getClass().getEnumConstants()) {
            if (!e2.name().equalsIgnoreCase(value)) continue;
            this.value = e2;
        }
    }

    public String currentEnumName() {
        return EnumConverter.getProperName((Enum)this.value);
    }

    public int currentEnum() {
        return EnumConverter.currentEnum((Enum)this.value);
    }

    public void increaseEnum() {
        this.plannedValue = EnumConverter.increaseEnum((Enum)this.value);
        IllIlIIlIIlllIllIIllIIIlllIlllIllIIIllIIllIIlllIllIlllIIllIlIIlIlIIllIlIIllIIIlllIIIlIIllIllIIlIIlIIIllIIIllIIlllIIllIIlIIIlIIlIlllIlllIlllIllIIlllIIlIlllIIIlIIIllIlllIIllIllIIllIIlIIIllIIllIlIlIlllIlIIlIIllIllIIllIIIllIl event = new IllIlIIlIIlllIllIIllIIIlllIlllIllIIIllIIllIIlllIllIlllIIllIlIIlIlIIllIlIIllIIIlllIIIlIIllIllIIlIIlIIIllIIIllIIlllIIllIIlIIIlIIlIlllIlllIlllIllIIlllIIlIlllIIIlIIIllIlllIIllIllIIllIIlIIIllIIllIlIlIlllIlIIlIIllIllIIllIIIllIl(this);
        MinecraftForge.EVENT_BUS.post((Event)event);
        if (!event.isCanceled()) {
            this.value = this.plannedValue;
        } else {
            this.plannedValue = this.value;
        }
    }

    public void increaseEnumNoEvent() {
        this.value = EnumConverter.increaseEnum((Enum)this.value);
    }

    public String getType() {
        if (this.isEnumSetting()) {
            return "Enum";
        }
        return this.getClassName(this.defaultValue);
    }

    public <T> String getClassName(T value) {
        return value.getClass().getSimpleName();
    }

    public String getDescription() {
        if (this.description == null) {
            return "";
        }
        return this.description;
    }

    public boolean isNumberSetting() {
        return this.value instanceof Double || this.value instanceof Integer || this.value instanceof Short || this.value instanceof Long || this.value instanceof Float;
    }

    public boolean isEnumSetting() {
        return !this.isNumberSetting() && !(this.value instanceof String) && !(this.value instanceof Bind) && !(this.value instanceof Character) && !(this.value instanceof Boolean);
    }

    public boolean isStringSetting() {
        return this.value instanceof String;
    }

    public T getDefaultValue() {
        return this.defaultValue;
    }

    public String getValueAsString() {
        return this.value.toString();
    }

    public boolean hasRestriction() {
        return this.hasRestriction;
    }

    public void setVisibility(Predicate<T> visibility) {
        this.visibility = visibility;
    }

    public Setting<T> setRenderName(boolean renderName) {
        this.shouldRenderStringName = renderName;
        return this;
    }

    public boolean shouldRenderName() {
        if (!this.isStringSetting()) {
            return true;
        }
        return this.shouldRenderStringName;
    }

    public boolean isVisible() {
        if (this.visibility == null) {
            return false;
        }
        return !this.visibility.test(this.getValue());
    }
}

