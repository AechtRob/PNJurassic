
package net.pnjurassic.world.dimension.jurassic;

import net.lepidodendron.ElementsLepidodendronMod;
import net.lepidodendron.LepidodendronConfig;
import net.lepidodendron.LepidodendronConfigPlants;
import net.lepidodendron.LepidodendronDecorationHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenFossils;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraftforge.common.BiomeDictionary;
import net.pnjurassic.ElementsPNJurassicMod;
import net.pnjurassic.world.biome.jurassic.BiomeJurassicDesert;

import java.util.Random;

@ElementsPNJurassicMod.ModElement.Tag
public class GenVanillaFossils extends ElementsPNJurassicMod.ModElement {

	private static final ResourceLocation STRUCTURE_SPINE_01 = new ResourceLocation("fossils/fossil_spine_01");
	private static final ResourceLocation STRUCTURE_SPINE_02 = new ResourceLocation("fossils/fossil_spine_02");
	private static final ResourceLocation STRUCTURE_SPINE_03 = new ResourceLocation("fossils/fossil_spine_03");
	private static final ResourceLocation STRUCTURE_SPINE_04 = new ResourceLocation("fossils/fossil_spine_04");
//	private static final ResourceLocation STRUCTURE_SKULL_01 = new ResourceLocation("fossils/fossil_skull_01");
//	private static final ResourceLocation STRUCTURE_SKULL_02 = new ResourceLocation("fossils/fossil_skull_02");
//	private static final ResourceLocation STRUCTURE_SKULL_03 = new ResourceLocation("fossils/fossil_skull_03");
//	private static final ResourceLocation STRUCTURE_SKULL_04 = new ResourceLocation("fossils/fossil_skull_04");
	private static final ResourceLocation[] FOSSILS = new ResourceLocation[] {STRUCTURE_SPINE_01, STRUCTURE_SPINE_02, STRUCTURE_SPINE_03, STRUCTURE_SPINE_04
//		, STRUCTURE_SKULL_01, STRUCTURE_SKULL_02, STRUCTURE_SKULL_03, STRUCTURE_SKULL_04
	};

	public GenVanillaFossils(ElementsPNJurassicMod instance) {
		super(instance, 1);
	}

	@Override
	public void generateWorld(Random random, int i2, int k2, World world, int dimID, IChunkGenerator cg, IChunkProvider cp) {

		if (world.isRemote)
			return;

		Biome biome = world.getBiome(new BlockPos(i2, world.getSeaLevel(), k2));

		if (biome != BiomeJurassicDesert.biome)
			return;

		int GenChance = 3300;

		if ((random.nextInt(1000000) + 1) <= GenChance) {
			int count = random.nextInt(1) + 1;
			for (int a = 0; a < count; a++) {
				int i = i2 + random.nextInt(16) + 8;
				int k = k2 + random.nextInt(16) + 8;
				int height = 255;
				while (height > 0) {
					if (
						(!world.isAirBlock(new BlockPos(i, height, k)))
						&& ((world.getBlockState(new BlockPos(i, height, k))).getMaterial() != Material.VINE)
						&& ((world.getBlockState(new BlockPos(i, height, k))).getMaterial() != Material.WEB)
						&& ((world.getBlockState(new BlockPos(i, height, k))).getMaterial() != Material.PLANTS)
					)
					break;
					height--;
				}

				int j = height;
				boolean blockCriteria = false;
				if ((world.getBlockState(new BlockPos(i, j, k))).getMaterial() == Material.SAND)
					blockCriteria = true;
				if (!blockCriteria)
					continue;

				Template template = ((WorldServer) world).getStructureTemplateManager().getTemplate(world.getMinecraftServer(),FOSSILS[random.nextInt(FOSSILS.length)]);
				if (template == null)
					return;
				Rotation[] arotation = Rotation.values();
				Rotation rotation = arotation[random.nextInt(arotation.length)];
				Mirror mirror = Mirror.values()[random.nextInt(2)];
				BlockPos spawnTo = new BlockPos(i, j + random.nextInt(4) - 10, k);
				IBlockState iblockstate = world.getBlockState(spawnTo);
				world.notifyBlockUpdate(spawnTo, iblockstate, iblockstate, 3);
				template.addBlocksToWorldChunk(world, spawnTo, new PlacementSettings().setRotation(rotation).setMirror(mirror)
						.setChunk((ChunkPos) null).setReplacedBlock((Block) null).setIgnoreStructureBlock(false).setIgnoreEntities(false).setIntegrity(0.9F));
			}
		}
	}

}
