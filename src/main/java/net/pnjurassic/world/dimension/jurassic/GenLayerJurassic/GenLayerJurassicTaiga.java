package net.pnjurassic.world.dimension.jurassic.GenLayerJurassic;

import net.lepidodendron.util.EnumBiomeTypePermian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pnjurassic.world.biome.jurassic.BiomeJurassicSouthernTaiga;

public class GenLayerJurassicTaiga extends GenLayer {

    public Biome JURASSIC_TAIGA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_southern_taiga"));
    public int JURASSIC_TAIGA_ID =  Biome.getIdForBiome(JURASSIC_TAIGA);
    public Biome JURASSIC_TAIGA_HILLS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_southern_taiga_hills"));
    public int JURASSIC_TAIGA_HILLS_ID =  Biome.getIdForBiome(JURASSIC_TAIGA_HILLS);
    public Biome JURASSIC_TAIGA_FOREST = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_southern_taiga_forest"));
    public int JURASSIC_TAIGA_FOREST_ID =  Biome.getIdForBiome(JURASSIC_TAIGA_FOREST);


    private final int[] TaigaBiomes = new int[] {
            JURASSIC_TAIGA_ID,
            JURASSIC_TAIGA_ID,
            JURASSIC_TAIGA_ID,
            JURASSIC_TAIGA_FOREST_ID,
            JURASSIC_TAIGA_FOREST_ID,
            JURASSIC_TAIGA_FOREST_ID,
            JURASSIC_TAIGA_HILLS_ID,
            JURASSIC_TAIGA_HILLS_ID
    };

    public GenLayerJurassicTaiga(long seed, GenLayer genlayer) {
        super(seed);
        this.parent = genlayer;
    }

    @Override
    public int[] getInts(int x, int z, int width, int height) {
        return diversify(x, z, width, height);
    }

    private int[] diversify(int x, int z, int width, int height) {
        int[] input = this.parent.getInts(x, z, width, height);
        int[] output = IntCache.getIntCache(width * height);
        EnumBiomeTypePermian type;
        for (int zOut = 0; zOut < height; zOut++) {
            for (int xOut = 0; xOut < width; xOut++) {
                int i = xOut + zOut * width;
                int center = input[i];
                initChunkSeed(xOut + x, zOut + z);
                if (nextInt(2) == 0) {
                    if (Biome.getBiome(center) == BiomeJurassicSouthernTaiga.biome)
                        output[i] = TaigaBiomes[nextInt(TaigaBiomes.length)];

                    else output[i] = center;
                } else output[i] = center;
            }
        }
        return output;
    }

}