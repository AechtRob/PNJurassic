package net.pnjurassic.world.dimension.jurassic.GenLayerJurassic;

import net.lepidodendron.util.EnumBiomeTypePermian;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import net.pnjurassic.world.biome.jurassic.BiomeJurassicMire;
import net.pnjurassic.world.biome.jurassic.BiomeJurassicMireHelper;
import net.pnjurassic.world.biome.jurassic.BiomeJurassicMudflats;
import net.pnjurassic.world.biome.jurassic.BiomeJurassicMudflatsHelper;

public class GenLayerDiversifyJurassicMudflats extends GenLayer {

    public Biome JURASSIC_MUDFLATS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_mudflats"));
    public int JURASSIC_MUDFLATS_ID =  Biome.getIdForBiome(JURASSIC_MUDFLATS);
    public Biome JURASSIC_MUDFLATS_HELPER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_mudflats_helper"));
    public int JURASSIC_MUDFLATS_HELPER_ID =  Biome.getIdForBiome(JURASSIC_MUDFLATS_HELPER);
    public Biome JURASSIC_MIRE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_mire"));
    public int JURASSIC_MIRE_ID =  Biome.getIdForBiome(JURASSIC_MIRE);
    public Biome JURASSIC_MIRE_HELPER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_mire_helper"));
    public int JURASSIC_MIRE_HELPER_ID =  Biome.getIdForBiome(JURASSIC_MIRE_HELPER);

    private final int[] MudflatsBiomes = new int[] {
            JURASSIC_MUDFLATS_ID,
            JURASSIC_MUDFLATS_ID,
            JURASSIC_MUDFLATS_HELPER_ID
    };

    private final int[] MireBiomes = new int[] {
            JURASSIC_MIRE_ID,
            JURASSIC_MIRE_ID,
            JURASSIC_MIRE_HELPER_ID
    };

    public GenLayerDiversifyJurassicMudflats(long seed, GenLayer genlayer) {
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
                    if (Biome.getBiome(center) == BiomeJurassicMudflats.biome
                        || Biome.getBiome(center) == BiomeJurassicMudflatsHelper.biome)
                        output[i] = MudflatsBiomes[nextInt(MudflatsBiomes.length)];
                    else if (Biome.getBiome(center) == BiomeJurassicMire.biome
                            || Biome.getBiome(center) == BiomeJurassicMireHelper.biome)
                        output[i] = MireBiomes[nextInt(MireBiomes.length)];
                    else output[i] = center;
                } else output[i] = center;
            }
        }
        return output;
    }

}