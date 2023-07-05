
package net.pnjurassic.world.biome.jurassic;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.block.BlockCoral;
import net.lepidodendron.block.BlockGlassSpongeReef;
import net.lepidodendron.block.BlockSandPangaean;
import net.lepidodendron.block.BlockSpongeReef;
import net.lepidodendron.util.EnumBiomeTypeJurassic;
import net.lepidodendron.util.EnumBiomeTypePermian;
import net.lepidodendron.world.biome.jurassic.BiomeJurassic;
import net.lepidodendron.world.biome.permian.BiomePermian;
import net.lepidodendron.world.gen.GlassSpongeReefGenerator;
import net.lepidodendron.world.gen.WorldGenNullTree;
import net.lepidodendron.world.gen.WorldGenReef;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class BiomeJurassicGlassSpongeReef extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:jurassic_ocean_glass_sponge_reef")
	public static final BiomeGenCustom biome = null;
	public BiomeJurassicGlassSpongeReef(ElementsLepidodendronMod instance) {
		super(instance, 1591);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.OCEAN);
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.WATER);
	}

	static class BiomeGenCustom extends BiomeJurassic {
		public BiomeGenCustom() {
			super(new BiomeProperties("Jurassic Glass Sponge Reef").setBaseHeight(-1.45F).setHeightVariation(0.425F));
			setRegistryName("lepidodendron:jurassic_ocean_glass_sponge_reef");
			topBlock = Blocks.SAND.getStateFromMeta(0);
			fillerBlock = Blocks.SAND.getStateFromMeta(0);
			decorator.treesPerChunk = -999;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.mushroomsPerChunk = 20;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 0;
			decorator.gravelPatchesPerChunk = 0;
			decorator.clayPerChunk = 0;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
		}

		protected static final WorldGenNullTree NULL_TREE = new WorldGenNullTree(false);
		protected static final WorldGenReef REEF_GENERATOR = new WorldGenReef();

		public WorldGenAbstractTree getRandomTreeFeature(Random rand)
	    {
	    	return NULL_TREE;
	    }

		@Override
	    public void decorate(World worldIn, Random rand, BlockPos pos)
	    {

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.ROCK))
				for (int i = 0; i < 8; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					BlockPos pos1 = pos.add(j, l, k);
					if (
							(pos1.getY() < worldIn.getSeaLevel() - 5)
									&& (worldIn.getBlockState(pos1).getMaterial() == Material.WATER)
									&& (worldIn.getBlockState(pos1.up()).getMaterial() == Material.WATER)
									&& (worldIn.getBlockState(pos1.up(2)).getMaterial() == Material.WATER)
					) {
						REEF_GENERATOR.generate(worldIn, rand, pos1, 3, BlockCoral.block.getDefaultState());
					}
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.ROCK))
				for (int i = 0; i < 3; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 12);
					BlockPos pos1 = pos.add(j, l, k);
					if (
							(pos1.getY() < worldIn.getSeaLevel() - 5)
									&& (worldIn.getBlockState(pos1).getMaterial() == Material.WATER)
									&& (worldIn.getBlockState(pos1.up()).getMaterial() == Material.WATER)
									&& (worldIn.getBlockState(pos1.up(2)).getMaterial() == Material.WATER)
					) {
						REEF_GENERATOR.generate(worldIn, rand, pos1, 3, BlockGlassSpongeReef.block.getDefaultState());
					}
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.ROCK))
				for (int i = 0; i < 3; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 12);
					BlockPos pos1 = pos.add(j, l, k);
					if (
							(pos1.getY() < worldIn.getSeaLevel() - 5)
									&& (worldIn.getBlockState(pos1).getMaterial() == Material.WATER)
									&& (worldIn.getBlockState(pos1.up()).getMaterial() == Material.WATER)
									&& (worldIn.getBlockState(pos1.up(2)).getMaterial() == Material.WATER)
					) {
						REEF_GENERATOR.generate(worldIn, rand, pos1, 6, BlockGlassSpongeReef.block.getDefaultState());
					}
				}

	        super.decorate(worldIn, rand, pos);
	    }

		@Override
		public EnumBiomeTypeJurassic getBiomeType() {
			return EnumBiomeTypeJurassic.Ocean;
		}

	}

}
