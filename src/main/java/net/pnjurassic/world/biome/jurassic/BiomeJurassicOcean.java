
package net.pnjurassic.world.biome.jurassic;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.block.*;
import net.lepidodendron.util.EnumBiomeTypeJurassic;
import net.lepidodendron.world.biome.ChunkGenSpawner;
import net.lepidodendron.world.biome.jurassic.BiomeJurassic;
import net.lepidodendron.world.gen.*;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

@ElementsLepidodendronMod.ModElement.Tag
public class BiomeJurassicOcean extends ElementsLepidodendronMod.ModElement {
	@GameRegistry.ObjectHolder("lepidodendron:jurassic_ocean")
	public static final BiomeGenCustom biome = null;
	public BiomeJurassicOcean(ElementsLepidodendronMod instance) {
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
			super(new BiomeProperties("Jurassic Deep Ocean").setBaseHeight(-1.85F).setHeightVariation(0.21F));
			setRegistryName("lepidodendron:jurassic_ocean");
			topBlock = Blocks.SAND.getDefaultState();
			fillerBlock = Blocks.SAND.getDefaultState();
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
		
		
		protected static final WorldGenBrachyphyllumTree BRACHYPHYLLUM = new WorldGenBrachyphyllumTree(false);
		protected static final WorldGenReef REEF_GENERATOR = new WorldGenReef();
		protected static final WorldGenSingleStaticInWaterUpwards STATIC_GENERATOR = new WorldGenSingleStaticInWaterUpwards();
		protected static final WorldGenSingleStaticInWaterRotational STATIC_ROTATIONAL_GENERATOR = new WorldGenSingleStaticInWaterRotational();
		protected static final WorldGenSingleStaticInWaterSideways STATIC_SIDEWAYS_GENERATOR = new WorldGenSingleStaticInWaterSideways();
		protected static final WorldGenSingleStaticInWaterColumn STATIC_COLUMN_GENERATOR = new WorldGenSingleStaticInWaterColumn();
		protected static final WorldGenSingleAnemoneSea ANEMONE_GENERATOR = new WorldGenSingleAnemoneSea();
		protected static final WorldGenSingleSponge SPONGE_GENERATOR = new WorldGenSingleSponge();
		protected static final WorldGenSingleSpongeSideways SPONGE_SIDEWAYS_GENERATOR = new WorldGenSingleSpongeSideways();
		protected static final WorldGenSingleCoral CORAL_GENERATOR = new WorldGenSingleCoral();
		protected static final WorldGenSingleCoralSideways CORAL_SIDEWAYS_GENERATOR = new WorldGenSingleCoralSideways();

		public WorldGenAbstractTree getRandomTreeFeature(Random rand)
	    {
	    	return BRACHYPHYLLUM;
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


			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 19; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					STATIC_GENERATOR.generate(BlockBivalveInoceramus.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 12, 255, 0, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 26; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					STATIC_ROTATIONAL_GENERATOR.generate(BlockCrinoidHemicrinus.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 12, 255, 0, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 16; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					STATIC_GENERATOR.generate(BlockBivalveWhite.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 255, 0, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 29; ++ii)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					STATIC_GENERATOR.generate(BlockTentaculita.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 255, 0, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 29; ++ii)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					STATIC_SIDEWAYS_GENERATOR.generate(BlockTentaculita.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 255, 0, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 10; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					SPONGE_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 10; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					SPONGE_SIDEWAYS_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 10; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					ANEMONE_GENERATOR.generate(worldIn, rand, pos.add(j, l, k));
				}









			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 12; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					STATIC_COLUMN_GENERATOR.generate(BlockGreenStemmedAlgae.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 20, 0, 255, 5);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int i = 0; i < 17; ++i)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getHeight(pos.add(j, 0, k)).getY() + 32);
					STATIC_GENERATOR.generate(BlockGreenLeafyAlgae.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 15, 0, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 5; ++ii)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					STATIC_GENERATOR.generate(BlockRedAlgaeMat.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 30, 0, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 17; ++ii)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					STATIC_GENERATOR.generate(BlockGreenAlgaeMat.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 15, 0, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 5; ++ii)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					STATIC_GENERATOR.generate(BlockRedTuftedAlgae.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 30, 0, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 5; ++ii)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					STATIC_SIDEWAYS_GENERATOR.generate(BlockRedTuftedAlgae.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 30, 0, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 12; ++ii)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					STATIC_GENERATOR.generate(BlockGreenCodiumAlgae.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 15, 0, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 12; ++ii)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					STATIC_SIDEWAYS_GENERATOR.generate(BlockGreenCodiumAlgae.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 15, 0, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 17; ++ii)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					STATIC_GENERATOR.generate(BlockGreenCrustedAlgae.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 15, 0, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 17; ++ii)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					STATIC_SIDEWAYS_GENERATOR.generate(BlockGreenCrustedAlgae.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 15, 0, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 17; ++ii)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					STATIC_GENERATOR.generate(BlockGreenSproutingAlgae.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 15, 0, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 17; ++ii)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					STATIC_GENERATOR.generate(BlockPiledAlgae.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 15, 0, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 5; ++ii)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					STATIC_GENERATOR.generate(BlockRedLeafyAlgae.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 30, 0, 255);
				}

			if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, new net.minecraft.util.math.ChunkPos(pos), DecorateBiomeEvent.Decorate.EventType.GRASS))
				for (int ii = 0; ii < 5; ++ii)
				{
					int j = rand.nextInt(16) + 8;
					int k = rand.nextInt(16) + 8;
					int l = rand.nextInt(worldIn.getSeaLevel() + 25);
					STATIC_GENERATOR.generate(BlockStalkedAlgae.block.getDefaultState(), worldIn, rand, pos.add(j, l, k), 1, 15, 0, 255);
				}

	        super.decorate(worldIn, rand, pos);
	    }

		@Override
		public EnumBiomeTypeJurassic getBiomeType() {
			return EnumBiomeTypeJurassic.Ocean;
		}

	}

}
