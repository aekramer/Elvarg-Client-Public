package com.runescape.entity.model;

import net.runelite.rs.api.RSVertexNormal;

public final class VertexNormal implements RSVertexNormal {

    public int x;
    public int y;
    public int z;
    public int magnitude;

    public VertexNormal() {
    }

    public VertexNormal(VertexNormal var1) {
        this.x = var1.x;
        this.y = var1.y;
        this.z = var1.z;
        this.magnitude = var1.magnitude;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getZ() {
        return z;
    }
}
