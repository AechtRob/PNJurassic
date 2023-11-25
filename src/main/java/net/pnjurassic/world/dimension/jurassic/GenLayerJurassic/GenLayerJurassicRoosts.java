package net.pnjurassic.world.dimension.jurassic.GenLayerJurassic;

import net.lepidodendron.util.EnumBiomeTypePermian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pnjurassic.world.biome.jurassic.BiomeJurassicIslandLargeRim;
import net.pnjurassic.world.biome.jurassic.BiomeJurassicSandyIslandHills;

public class GenLayerJurassicRoosts extends GenLayer {

    public Biome JURASSIC_RIM = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_island_large"));
    public int JURASSIC_RIM_ID =  Biome.getIdForBiome(JURASSIC_RIM);
    public Biome JURASSIC_ROOST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_island_large_roost"));
    public int JURASSIC_CALDERA_ROOST_ID =  Biome.getIdForBiome(JURASSIC_ROOST);

    public Biome JURASSIC_SANDY = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_island_sandy_hills"));
    public int JURASSIC_SANDY_ID =  Biome.getIdForBiome(JURASSIC_SANDY);
    public Biome JURASSIC_SANDY_ROOST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_island_sandy_hills_roost"));
    public int JURASSIC_SANDY_ROOST_ID =  Biome.getIdForBiome(JURASSIC_SANDY_ROOST);

    private final int CalderaRoostBiomes[] = new int[] {
            JURASSIC_RIM_ID,
            JURASSIC_RIM_ID,
            JURASSIC_RIM_ID,
            JURASSIC_RIM_ID,
            JURASSIC_RIM_ID,
            JURASSIC_RIM_ID,
            JURASSIC_CALDERA_ROOST_ID
    };

    private final int SandyRoostBiomes[] = new int[] {
            JURASSIC_SANDY_ID,
            JURASSIC_SANDY_ID,
            JURASSIC_SANDY_ID,
            JURASSIC_SANDY_ID,
            JURASSIC_SANDY_ID,
            JURASSIC_SANDY_ID,
            JURASSIC_SANDY_ROOST_ID
    };

    public GenLayerJurassicRoosts(long seed, GenLayer genlayer) {
        super(seed);
        this.parent = genlayer;
    }

    @Override
    public int[] getInts(int x, int z, int width, int height) {
        return diversify(x, z, width, height);
    }

    private int[] diversify(int x, int z, int width, int height) {
        int input[] = this.parent.getInts(x, z, width, height);
        int output[] = IntCache.getIntCache(width * height);
        EnumBiomeTypePermian type;
        for (int zOut = 0; zOut < height; zOut++) {
            for (int xOut = 0; xOut < width; xOut++) {
                int i = xOut + zOut * width;
                int center = input[i];
                initChunkSeed(xOut + x, zOut + z);
                if (nextInt(2) == 0) {
                    if (Biome.getBiome(center) == BiomeJurassicIslandLargeRim.biome)
                        output[i] = CalderaRoostBiomes[nextInt(CalderaRoostBiomes.length)];

                    if (Biome.getBiome(center) == BiomeJurassicSandyIslandHills.biome)
                        output[i] = SandyRoostBiomes[nextInt(SandyRoostBiomes.length)];

                    else output[i] = center;
                } else output[i] = center;
            }
        }
        return output;
    }

}