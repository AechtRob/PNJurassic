package net.pnjurassic.world.dimension.jurassic.GenLayerJurassic;

import net.lepidodendron.util.EnumBiomeTypeJurassic;
import net.lepidodendron.world.biome.jurassic.BiomeJurassic;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerJurassicRiverMix extends GenLayer
{
    private final GenLayer biomePatternGeneratorChain;
    private final GenLayer riverPatternGeneratorChain;

    public Biome JURASSIC_RIVER = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_river"));
    public int JURASSIC_RIVER_ID = Biome.getIdForBiome(JURASSIC_RIVER);

    //Creeks to use:
    public Biome JURASSIC_CREEK_FERN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_creek_fern_pasture"));
    public int JURASSIC_CREEK_FERN_ID = Biome.getIdForBiome(JURASSIC_CREEK_FERN);
    public Biome JURASSIC_CREEK_FLOODPLAIN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_creek_floodplain"));
    public int JURASSIC_CREEK_FLOODPLAIN_ID = Biome.getIdForBiome(JURASSIC_CREEK_FLOODPLAIN);
    public Biome JURASSIC_CREEK_GARRIGUE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_creek_garrigue"));
    public int JURASSIC_CREEK_GARRIGUE_ID = Biome.getIdForBiome(JURASSIC_CREEK_GARRIGUE);
    public Biome JURASSIC_CREEK_REDWOOD = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_creek_redwood_forest"));
    public int JURASSIC_CREEK_REDWOOD_ID = Biome.getIdForBiome(JURASSIC_CREEK_REDWOOD);
    public Biome JURASSIC_CREEK_SOUTHERN_TAIGA = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_creek_southern_taiga"));
    public int JURASSIC_CREEK_SOUTHERN_TAIGA_ID = Biome.getIdForBiome(JURASSIC_CREEK_SOUTHERN_TAIGA);
    public Biome JURASSIC_CREEK_GINKGO = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_creek_ginkgo_woodland"));
    public int JURASSIC_CREEK_GINKGO_ID = Biome.getIdForBiome(JURASSIC_CREEK_GINKGO);
    public Biome JURASSIC_CREEK_COASTAL = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_creek_coastal"));
    public int JURASSIC_CREEK_COASTAL_ID = Biome.getIdForBiome(JURASSIC_CREEK_COASTAL);
    public Biome JURASSIC_CREEK_MIRE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_mire_lakes"));
    public int JURASSIC_CREEK_MIRE_ID = Biome.getIdForBiome(JURASSIC_CREEK_MIRE);

    //Biomes to exclude for rivers:
    public Biome JURASSIC_OCEAN_SHORE = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean_shore"));
    public int JURASSIC_OCEAN_SHORE_ID =  Biome.getIdForBiome(JURASSIC_OCEAN_SHORE);
    public Biome JURASSIC_OCEAN = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean"));
    public  int JURASSIC_OCEAN_ID =  Biome.getIdForBiome(JURASSIC_OCEAN);
    public Biome JURASSIC_GLASS_SPONGE_REEF = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_ocean_glass_sponge_reef"));
    public  int JURASSIC_GLASS_SPONGE_REEF_ID =  Biome.getIdForBiome(JURASSIC_GLASS_SPONGE_REEF);
    public  Biome JURASSIC_MOUNTAINS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_rough_hills"));
    public  int JURASSIC_MOUNTAINS_ID =  Biome.getIdForBiome(JURASSIC_MOUNTAINS);
    public  Biome JURASSIC_ATOLLS = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_sandbanks"));
    public  int JURASSIC_ATOLLS_ID =  Biome.getIdForBiome(JURASSIC_ATOLLS);
    public  Biome JURASSIC_ATOLLS2 = Biome.REGISTRY.getObject(new ResourceLocation("lepidodendron:jurassic_sandbanks_raised"));
    public  int JURASSIC_ATOLLS2_ID =  Biome.getIdForBiome(JURASSIC_ATOLLS2);

    public GenLayerJurassicRiverMix(long p_i2129_1_, GenLayer p_i2129_3_, GenLayer p_i2129_4_)
    {
        super(p_i2129_1_);
        this.biomePatternGeneratorChain = p_i2129_3_;
        this.riverPatternGeneratorChain = p_i2129_4_;
    }

    public void initWorldGenSeed(long seed)
    {
        this.biomePatternGeneratorChain.initWorldGenSeed(seed);
        this.riverPatternGeneratorChain.initWorldGenSeed(seed);
        super.initWorldGenSeed(seed);
    }

    public int[] getInts(int areaX, int areaY, int areaWidth, int areaHeight)
    {
        int[] aint = this.biomePatternGeneratorChain.getInts(areaX, areaY, areaWidth, areaHeight);
        int[] aint1 = this.riverPatternGeneratorChain.getInts(areaX, areaY, areaWidth, areaHeight);
        int[] aint2 = IntCache.getIntCache(areaWidth * areaHeight);

        for (int i = 0; i < areaWidth * areaHeight; ++i)
        {
            if (aint1[i] == Biome.getIdForBiome(Biomes.RIVER))
            {
                //Exclude rivers here:
                if (aint[i] == JURASSIC_OCEAN_SHORE_ID
                        || aint[i] == JURASSIC_OCEAN_ID
                        || aint[i] == JURASSIC_GLASS_SPONGE_REEF_ID
                        || aint[i] == JURASSIC_MOUNTAINS_ID
                        || aint[i] == JURASSIC_ATOLLS_ID
                        || aint[i] == JURASSIC_ATOLLS2_ID
                )
                {
                    aint2[i] = aint[i];
                }
                else {
                    //Add the rivers we want:
                    Biome biome = Biome.getBiome(aint[i]);
                    if (biome instanceof BiomeJurassic) {
                        BiomeJurassic biomeJurassic = (BiomeJurassic) biome;
                        if (biomeJurassic.getBiomeType() == EnumBiomeTypeJurassic.Garrigue
                            || biomeJurassic.getBiomeType() == EnumBiomeTypeJurassic.Rocks) {
                            aint2[i] = JURASSIC_CREEK_GARRIGUE_ID;
                        }
                        else if (biomeJurassic.getBiomeType() == EnumBiomeTypeJurassic.Forest
                            || biomeJurassic.getBiomeType() == EnumBiomeTypeJurassic.Floodplain) {
                            aint2[i] = JURASSIC_CREEK_FLOODPLAIN_ID;
                        }
                        else if (biomeJurassic.getBiomeType() == EnumBiomeTypeJurassic.Ginkgo) {
                            aint2[i] = JURASSIC_CREEK_GINKGO_ID;
                        }
                        else if (biomeJurassic.getBiomeType() == EnumBiomeTypeJurassic.Pasture) {
                            aint2[i] = JURASSIC_CREEK_FERN_ID;
                        }
                        else if (biomeJurassic.getBiomeType() == EnumBiomeTypeJurassic.Redwood) {
                            aint2[i] = JURASSIC_CREEK_REDWOOD_ID;
                        }
                        else if (biomeJurassic.getBiomeType() == EnumBiomeTypeJurassic.Taiga) {
                            aint2[i] = JURASSIC_CREEK_SOUTHERN_TAIGA_ID;
                        }
                        else if (biomeJurassic.getBiomeType() == EnumBiomeTypeJurassic.Ocean) {
                            aint2[i] = JURASSIC_CREEK_COASTAL_ID;
                        }
                        else if (biomeJurassic.getBiomeType() == EnumBiomeTypeJurassic.Mire) {
                            aint2[i] = JURASSIC_CREEK_MIRE_ID;
                        }
                        else {
                            aint2[i] = JURASSIC_RIVER_ID;
                        }
                    }
                    else {
                        aint2[i] = JURASSIC_RIVER_ID;
                    }
                }
            }
            else
            {
                aint2[i] = aint[i];
            }

        }

        return aint2;
    }
}
