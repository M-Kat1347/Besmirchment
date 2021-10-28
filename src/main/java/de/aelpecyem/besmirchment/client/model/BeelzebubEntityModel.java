// Made with Model Converter by Globox_Z
// Generate all required imports
// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports
package de.aelpecyem.besmirchment.client.model;

import de.aelpecyem.besmirchment.common.entity.BeelzebubEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Arm;
import net.minecraft.util.math.MathHelper;

public class BeelzebubEntityModel<T extends BeelzebubEntity> extends BipedEntityModel<T> {

    private final ModelPart chest;
    private final ModelPart chest2_r1;
    private final ModelPart stomach;
    private final ModelPart fSkirt01;
    private final ModelPart lSkirt01;
    private final ModelPart lSkirt02;
    private final ModelPart rSkirt01;
    private final ModelPart rSkirt02;
    private final ModelPart bSkirt01;
    private final ModelPart fSkirt02;
    private final ModelPart lFLeg01;
    private final ModelPart lFLeg02;
    private final ModelPart lFLeg03;
    private final ModelPart lFLegClaw01;
    private final ModelPart lFLegClaw02;
    private final ModelPart lFLegSpur;
    private final ModelPart lBLeg01;
    private final ModelPart lBLeg02;
    private final ModelPart Box_r1;
    private final ModelPart lBLeg03;
    private final ModelPart Box_r2;
    private final ModelPart lBLegClaw01;
    private final ModelPart Box_r3;
    private final ModelPart lBLegClaw02;
    private final ModelPart Box_r4;
    private final ModelPart lBLegSpur;
    private final ModelPart Box_r5;
    private final ModelPart rBLeg01;
    private final ModelPart rBLeg02;
    private final ModelPart Box_r6;
    private final ModelPart rBLeg03;
    private final ModelPart Box_r7;
    private final ModelPart rBLegClaw01;
    private final ModelPart Box_r8;
    private final ModelPart rBLegClaw02;
    private final ModelPart Box_r9;
    private final ModelPart rBLegSpur;
    private final ModelPart Box_r10;
    private final ModelPart rFLeg01;
    private final ModelPart rFLeg02;
    private final ModelPart rFLeg03;
    private final ModelPart rFLegClaw01;
    private final ModelPart rFLeg2;
    private final ModelPart rFLegSpur;
    private final ModelPart hoodLTop;
    private final ModelPart hoodRTop;
    private final ModelPart hoodLSide01;
    private final ModelPart hoodRSide01;
    private final ModelPart hoodLSide02;
    private final ModelPart hoodRSide02;
    private final ModelPart hoodPipe01;
    private final ModelPart hoodPipe02;
    private final ModelPart lEye;
    private final ModelPart rEye;
    private final ModelPart hoodBack;
    private final ModelPart lAntenna01;
    private final ModelPart lAntenna02;
    private final ModelPart lAntenna03;
    private final ModelPart lAntenna04;
    private final ModelPart lAntenna05;
    private final ModelPart lAntenna06;
    private final ModelPart rAntenna01;
    private final ModelPart rAntenna02;
    private final ModelPart rAntenna03;
    private final ModelPart rAntenna04;
    private final ModelPart rAntenna05;
    private final ModelPart rAntenna06;
    private final ModelPart chestCloth;
    private final ModelPart lArm01;
    private final ModelPart lArm02;
    private final ModelPart lSleeve01;
    private final ModelPart lSleeve02;
    private final ModelPart lArm03;
    private final ModelPart lClaw01;
    private final ModelPart lClaw02;
    private final ModelPart rArm01;
    private final ModelPart rArm02;
    private final ModelPart rSleeve01;
    private final ModelPart rSleeve02;
    private final ModelPart rArm03;
    private final ModelPart rClaw01;
    private final ModelPart rClaw02;
    private final ModelPart lWing01;
    private final ModelPart lWing02;
    private final ModelPart lWing03;
    private final ModelPart lWingMembrane;
    private final ModelPart lWingLower01;
    private final ModelPart lWingLower02;
    private final ModelPart lWingLower03;
    private final ModelPart lWingLowerMemebrane;
    private final ModelPart rWingLower01;
    private final ModelPart rWingLower02;
    private final ModelPart rWingLower03;
    private final ModelPart rWingLowerMemebrane;
    private final ModelPart rWing01;
    private final ModelPart rWing02;
    private final ModelPart rWing03;
    private final ModelPart rWingMembrane;
    private boolean realArm = false;

    public BeelzebubEntityModel(ModelPart root) {
        super(root);
        this.chest = root.getChild("chest");
        this.stomach = this.chest.getChild("stomach");
        this.rFLeg01 = this.stomach.getChild("rFLeg01");
        this.rFLeg02 = this.rFLeg01.getChild("rFLeg02");
        this.rFLeg03 = this.rFLeg02.getChild("rFLeg03");
        this.rFLegSpur = this.rFLeg03.getChild("rFLegSpur");
        this.rFLeg2 = this.rFLeg03.getChild("rFLeg2");
        this.rFLegClaw01 = this.rFLeg03.getChild("rFLegClaw01");
        this.rBLeg01 = this.stomach.getChild("rBLeg01");
        this.rBLeg02 = this.rBLeg01.getChild("rBLeg02");
        this.rBLeg03 = this.rBLeg02.getChild("rBLeg03");
        this.rBLegSpur = this.rBLeg03.getChild("rBLegSpur");
        this.Box_r10 = this.rBLegSpur.getChild("Box_r10");
        this.rBLegClaw02 = this.rBLeg03.getChild("rBLegClaw02");
        this.Box_r9 = this.rBLegClaw02.getChild("Box_r9");
        this.rBLegClaw01 = this.rBLeg03.getChild("rBLegClaw01");
        this.Box_r8 = this.rBLegClaw01.getChild("Box_r8");
        this.Box_r7 = this.rBLeg03.getChild("Box_r7");
        this.Box_r6 = this.rBLeg02.getChild("Box_r6");
        this.lBLeg01 = this.stomach.getChild("lBLeg01");
        this.lBLeg02 = this.lBLeg01.getChild("lBLeg02");
        this.lBLeg03 = this.lBLeg02.getChild("lBLeg03");
        this.lBLegSpur = this.lBLeg03.getChild("lBLegSpur");
        this.Box_r5 = this.lBLegSpur.getChild("Box_r5");
        this.lBLegClaw02 = this.lBLeg03.getChild("lBLegClaw02");
        this.Box_r4 = this.lBLegClaw02.getChild("Box_r4");
        this.lBLegClaw01 = this.lBLeg03.getChild("lBLegClaw01");
        this.Box_r3 = this.lBLegClaw01.getChild("Box_r3");
        this.Box_r2 = this.lBLeg03.getChild("Box_r2");
        this.Box_r1 = this.lBLeg02.getChild("Box_r1");
        this.lFLeg01 = this.stomach.getChild("lFLeg01");
        this.lFLeg02 = this.lFLeg01.getChild("lFLeg02");
        this.lFLeg03 = this.lFLeg02.getChild("lFLeg03");
        this.lFLegSpur = this.lFLeg03.getChild("lFLegSpur");
        this.lFLegClaw02 = this.lFLeg03.getChild("lFLegClaw02");
        this.lFLegClaw01 = this.lFLeg03.getChild("lFLegClaw01");
        this.bSkirt01 = this.stomach.getChild("bSkirt01");
        this.fSkirt02 = this.bSkirt01.getChild("fSkirt02");
        this.rSkirt01 = this.stomach.getChild("rSkirt01");
        this.rSkirt02 = this.rSkirt01.getChild("rSkirt02");
        this.lSkirt01 = this.stomach.getChild("lSkirt01");
        this.lSkirt02 = this.lSkirt01.getChild("lSkirt02");
        this.fSkirt01 = this.stomach.getChild("fSkirt01");
        this.chest2_r1 = this.chest.getChild("chest2_r1");

        this.hoodLTop = chest.getChild("head").getChild("hoodLTop");
        this.hoodRTop = chest.getChild("head").getChild("hoodRTop");
        this.hoodLSide01 = chest.getChild("head").getChild("hoodLSide01");
        this.hoodRSide01 = chest.getChild("head").getChild("hoodRSide01");
        this.hoodLSide02 = chest.getChild("head").getChild("hoodLSide02");
        this.hoodRSide02 = chest.getChild("head").getChild("hoodRSide02");
        this.hoodPipe01 = chest.getChild("head").getChild("hoodPipe01");
        this.hoodPipe02 = hoodPipe01.getChild("hoodPipe02");
        this.lEye = chest.getChild("head").getChild("lEye");
        this.rEye = chest.getChild("head").getChild("rEye");
        this.hoodBack = chest.getChild("head").getChild("hoodBack");
        this.lAntenna01 = chest.getChild("head").getChild("lAntenna01");
        this.lAntenna02 = lAntenna01.getChild("lAntenna02");
        this.lAntenna03 = lAntenna02.getChild("lAntenna03");
        this.lAntenna04 = lAntenna03.getChild("lAntenna04");
        this.lAntenna05 = lAntenna04.getChild("lAntenna05");
        this.lAntenna06 = lAntenna05.getChild("lAntenna06");
        this.rAntenna01 = chest.getChild("head").getChild("rAntenna01");
        this.rAntenna02 = rAntenna01.getChild("rAntenna02");
        this.rAntenna03 = rAntenna02.getChild("rAntenna03");
        this.rAntenna04 = rAntenna03.getChild("rAntenna04");
        this.rAntenna05 = rAntenna04.getChild("rAntenna05");
        this.rAntenna06 = rAntenna05.getChild("rAntenna06");
        this.chestCloth = chest.getChild("chestCloth");
        this.lArm01 = chest.getChild("lArm01");
        this.lArm02 = lArm01.getChild("lArm02");
        this.lSleeve01 = lArm02.getChild("lSleeve01");
        this.lSleeve02 = lSleeve01.getChild("lSleeve02");
        this.lArm03 = lArm02.getChild("lArm03");
        this.lClaw01 = lArm03.getChild("lClaw01");
        this.lClaw02 = lArm03.getChild("lClaw02");
        this.rArm01 = chest.getChild("rArm01");
        this.rArm02 = rArm01.getChild("rArm02");
        this.rSleeve01 = rArm02.getChild("rSleeve01");
        this.rSleeve02 = rSleeve01.getChild("rSleeve02");
        this.rArm03 = rArm02.getChild("rArm03");
        this.rClaw01 = rArm03.getChild("rClaw01");
        this.rClaw02 = rArm03.getChild("rClaw02");
        this.lWing01 = chest.getChild("lWing01");
        this.lWing02 = lWing01.getChild("lWing02");
        this.lWing03 = lWing02.getChild("lWing03");
        this.lWingMembrane = lWing01.getChild("lWingMembrane");
        this.lWingLower01 = chest.getChild("lWingLower01");
        this.lWingLower02 = lWingLower01.getChild("lWingLower02");
        this.lWingLower03 = lWingLower02.getChild("lWingLower03");
        this.lWingLowerMemebrane = lWingLower01.getChild("lWingLowerMemebrane");
        this.rWingLower01 = chest.getChild("rWingLower01");
        this.rWingLower02 = rWingLower01.getChild("rWingLower02");
        this.rWingLower03 = rWingLower02.getChild("rWingLower03");
        this.rWingLowerMemebrane = rWingLower01.getChild("rWingLowerMemebrane");
        this.rWing01 = chest.getChild("rWing01");
        this.rWing02 = rWing01.getChild("rWing02");
        this.rWing03 = rWing02.getChild("rWing03");
        this.rWingMembrane = rWing01.getChild("rWingMembrane");

    }

    public static TexturedModelData getTexturedModelData() {
        ModelData data = BipedEntityModel.getModelData(Dilation.NONE, 0);
        ModelPartData root = data.getRoot();
        ModelPartData chest = root.addChild("chest",
        ModelPartBuilder.create().cuboid(-7.5F, -9.0F, -5.5F, 15.0F, 9.0F, 11.0F), ModelTransform.of(0.0F, -19.5F, 0.0F, 0.0F, 0.0F, 0.0F));
        chest.addChild("chest2_r1", ModelPartBuilder.create().uv(5, 7).cuboid(-6.5F, 1.0F, -5.5F, 13.0F, 6.0F, 7.0F),
        ModelTransform.of(0.0F, -5.5F, 0.0F, -0.5672F, 0.0F, 0.0F));
        ModelPartData stomach = chest.addChild("stomach", ModelPartBuilder.create().uv(0, 40).cuboid(-6.5F, 0.0F, -4.5F, 13.0F, 18.0F, 9.0F), ModelTransform.of(0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F));stomach.addChild("fSkirt01", ModelPartBuilder.create().uv(1, 67).cuboid(-6.5F, -0.1F, -1.0F, 13.0F, 13.0F, 2.0F), ModelTransform.of(0.0F, 18.3F, -3.7F, -0.1745F, 0.0F, 0.0F));
        ModelPartData lSkirt01 = stomach.addChild("lSkirt01", ModelPartBuilder.create().uv(22, 74).mirrored(true).cuboid(-1.0F, 0.0F, -5.5F, 2.0F, 13.0F, 11.0F), ModelTransform.of(5.5F, 16.9F, 0.5F, 0.0F, 0.0F, -0.0873F));
        lSkirt01.addChild("lSkirt02", ModelPartBuilder.create().uv(38, 89).cuboid(-1.0F, 0.0F, -5.5F, 2.0F, 10.0F, 11.0F), ModelTransform.of(-0.1F, 12.8F, 0.0F, 0.0F, 0.0F, -0.0873F));
        ModelPartData rSkirt01 = stomach.addChild("rSkirt01", ModelPartBuilder.create().uv(22, 74).cuboid(-1.0F, 0.0F, -5.5F, 2.0F, 13.0F, 11.0F), ModelTransform.of(-5.5F, 16.9F, 0.5F, 0.0F, 0.0F, 0.0873F));
        rSkirt01.addChild("rSkirt02", ModelPartBuilder.create().uv(38, 89).mirrored(true).cuboid(-1.0F, 0.0F, -5.5F, 2.0F, 10.0F, 11.0F), ModelTransform.of(0.1F, 12.8F, 0.0F, 0.0F, 0.0F, 0.0873F));
        ModelPartData bSkirt01 = stomach.addChild("bSkirt01", ModelPartBuilder.create().uv(1, 99).cuboid(-6.5F, 0.0F, -1.0F, 13.0F, 15.0F, 2.0F), ModelTransform.of(0.0F, 17.2F, 4.1F, 0.2269F, 0.0F, 0.0F));
        bSkirt01.addChild("fSkirt02", ModelPartBuilder.create().uv(0, 116).cuboid(-6.5F, 0.0F, -1.0F, 13.0F, 10.0F, 2.0F), ModelTransform.of(0.0F, 14.7F, 0.0F, -0.2618F, 0.0F, 0.0F));
        ModelPartData lFLeg01 = stomach.addChild("lFLeg01", ModelPartBuilder.create().uv(107, 77).mirrored(true).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F), ModelTransform.of(3.7F, 17.6F, -1.9F, 0.1745F, -0.3491F, 0.0F));
        ModelPartData lFLeg02 = lFLeg01.addChild("lFLeg02", ModelPartBuilder.create().uv(108, 89).mirrored(true).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 12.0F, 3.0F), ModelTransform.of(-0.1F, 5.4F, -0.2F, -0.6981F, 0.0F, -0.0087F));
        ModelPartData lFLeg03 = lFLeg02.addChild("lFLeg03", ModelPartBuilder.create().uv(108, 106).mirrored(true).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 14.0F, 2.0F), ModelTransform.of(-0.1F, 11.2F, 0.2F, 0.48F, 0.0F, -0.1309F));
        lFLeg03.addChild("lFLegClaw01", ModelPartBuilder.create().uv(117, 108).mirrored(true).cuboid(-0.5F, -0.7F, -3.0F, 1.0F, 2.0F, 3.0F), ModelTransform.of(-0.2F, 12.7F, -0.5F, 0.3491F, 0.1396F, 0.1745F));
        lFLeg03.addChild("lFLegClaw02", ModelPartBuilder.create().uv(117, 108).mirrored(true).cuboid(-0.5F, -0.7F, -3.0F, 1.0F, 2.0F, 3.0F), ModelTransform.of(0.7F, 12.9F, -0.5F, 0.3491F, -0.2443F, 0.0524F));
        lFLeg03.addChild("lFLegSpur", ModelPartBuilder.create().uv(95, 63).mirrored(true).cuboid(0.0F, -4.0F, 0.0F, 0.0F, 8.0F, 5.0F), ModelTransform.of(0.0F, 4.4F, 0.0F, 0.0F, 0.0F, 0.0F));
        ModelPartData lBLeg01 = stomach.addChild("lBLeg01", ModelPartBuilder.create().uv(107, 77).mirrored(true).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F), ModelTransform.of(2.7F, 17.6F, 1.9F, -0.1745F, 0.3491F, 0.0F));
        ModelPartData lBLeg02 = lBLeg01.addChild("lBLeg02", ModelPartBuilder.create(), ModelTransform.of(-0.1F, 5.4F, 0.2F, 0.6981F, 0.0F, -0.0087F));
        lBLeg02.addChild("Box_r1", ModelPartBuilder.create().uv(108, 89).mirrored(true).cuboid(-3.9F, -23.5F, -0.4F, 3.0F, 12.0F, 3.0F), ModelTransform.of(-2.6F, 23.5F, -1.1F, 0.0F, 3.1416F, 0.0F));ModelPartData lBLeg03 = lBLeg02.addChild("lBLeg03",
        ModelPartBuilder.create(), ModelTransform.of(-0.1F, 11.2F, -0.2F, -0.48F, 0.0F, -0.1309F));lBLeg03.addChild("Box_r2", ModelPartBuilder.create().uv(108, 106).mirrored(true).cuboid(-3.5F, -12.3F, -0.1F, 2.0F, 14.0F, 2.0F), ModelTransform.of(-2.5F, 12.3F, -0.9F, 0.0F, 3.1416F, 0.0F));
        ModelPartData lBLegClaw01 = lBLeg03.addChild("lBLegClaw01", ModelPartBuilder.create(), ModelTransform.of(-0.2F, 12.7F, 0.5F, -0.3491F, -0.1396F, 0.1745F));
        lBLegClaw01.addChild("Box_r3", ModelPartBuilder.create().uv(117, 108).mirrored(true).cuboid(-2.2F, -0.3F, -2.6F, 1.0F, 2.0F, 3.0F), ModelTransform.of(-2.3F, -0.4F, -1.4F, 0.0F, 3.1416F, 0.0F));
        ModelPartData lBLegClaw02 = lBLeg03.addChild("lBLegClaw02", ModelPartBuilder.create(), ModelTransform.of(0.7F, 12.9F, 0.5F, -0.3491F, 0.2443F, 0.0524F));
        lBLegClaw02.addChild("Box_r4", ModelPartBuilder.create().uv(117, 108).mirrored(true).cuboid(-4.0F, -0.1F, -2.6F, 1.0F, 2.0F, 3.0F), ModelTransform.of(-3.2F, -0.6F, -1.4F, 0.0F, 3.1416F, 0.0F));
        ModelPartData lBLegSpur = lBLeg03.addChild("lBLegSpur", ModelPartBuilder.create(), ModelTransform.of(0.0F, 4.4F, 0.0F, 0.0F, 0.0F, 0.0F));
        lBLegSpur.addChild("Box_r5", ModelPartBuilder.create().uv(95, 63).mirrored(true).cuboid(-2.5F, -11.9F, 0.9F, 0.0F, 8.0F, 5.0F), ModelTransform.of(-2.5F, 7.9F, -0.9F, 0.0F, 3.1416F, 0.0F));
        ModelPartData rBLeg01 = stomach.addChild("rBLeg01", ModelPartBuilder.create().uv(107, 77).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F), ModelTransform.of(-2.7F, 17.6F, 1.9F, -0.1745F, -0.3491F, 0.0F));
        ModelPartData rBLeg02 = rBLeg01.addChild("rBLeg02", ModelPartBuilder.create(), ModelTransform.of(0.1F, 5.4F, 0.2F, 0.6981F, 0.0F, 0.0087F));
        rBLeg02.addChild("Box_r6", ModelPartBuilder.create().uv(108, 89).cuboid(0.9F, -23.5F, -0.4F, 3.0F, 12.0F, 3.0F), ModelTransform.of(2.6F, 23.5F, -1.1F, 0.0F, -3.1416F, 0.0F));
        ModelPartData rBLeg03 = rBLeg02.addChild("rBLeg03", ModelPartBuilder.create(), ModelTransform.of(0.1F, 11.2F, -0.2F, -0.48F, 0.0F, 0.1309F));
        rBLeg03.addChild("Box_r7", ModelPartBuilder.create().uv(108, 106).cuboid(1.5F, -12.3F, -0.1F, 2.0F, 14.0F, 2.0F), ModelTransform.of(2.5F, 12.3F, -0.9F, 0.0F, -3.1416F, 0.0F));
        ModelPartData rBLegClaw01 = rBLeg03.addChild("rBLegClaw01", ModelPartBuilder.create(), ModelTransform.of(0.2F, 12.7F, 0.5F, -0.3491F, 0.1396F, -0.1745F));
        rBLegClaw01.addChild("Box_r8", ModelPartBuilder.create().uv(117, 108).cuboid(1.2F, -0.3F, -2.6F, 1.0F, 2.0F, 3.0F), ModelTransform.of(2.3F, -0.4F, -1.4F, 0.0F, -3.1416F, 0.0F));
        ModelPartData rBLegClaw02 = rBLeg03.addChild("rBLegClaw02", ModelPartBuilder.create(), ModelTransform.of(-0.7F, 12.9F, 0.5F, -0.3491F, -0.2443F, -0.0524F));
        rBLegClaw02.addChild("Box_r9", ModelPartBuilder.create().uv(117, 108).cuboid(3.0F, -0.1F, -2.6F, 1.0F, 2.0F, 3.0F), ModelTransform.of(3.2F, -0.6F, -1.4F, 0.0F, -3.1416F, 0.0F));
        ModelPartData rBLegSpur = rBLeg03.addChild("rBLegSpur", ModelPartBuilder.create(), ModelTransform.of(0.0F, 4.4F, 0.0F, 0.0F, 0.0F, 0.0F));
        rBLegSpur.addChild("Box_r10", ModelPartBuilder.create().uv(95, 63).cuboid(2.5F, -11.9F, 0.9F, 0.0F, 8.0F, 5.0F), ModelTransform.of(2.5F, 7.9F, -0.9F, 0.0F, -3.1416F, 0.0F));
        ModelPartData rFLeg01 = stomach.addChild("rFLeg01", ModelPartBuilder.create().uv(107, 77).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F), ModelTransform.of(-3.7F, 17.6F, -1.9F, 0.1745F, 0.3491F, 0.0F));
        ModelPartData rFLeg02 = rFLeg01.addChild("rFLeg02", ModelPartBuilder.create().uv(108, 89).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 12.0F, 3.0F), ModelTransform.of(0.1F, 5.4F, -0.2F, -0.6981F, 0.0F, 0.0087F));
        ModelPartData rFLeg03 = rFLeg02.addChild("rFLeg03", ModelPartBuilder.create().uv(108, 106).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 14.0F, 2.0F), ModelTransform.of(0.1F, 11.2F, 0.2F, 0.48F, 0.0F, 0.1309F));
        rFLeg03.addChild("rFLegClaw01", ModelPartBuilder.create().uv(117, 108).cuboid(-0.5F, -0.7F, -3.0F, 1.0F, 2.0F, 3.0F), ModelTransform.of(0.2F, 12.7F, -0.5F, 0.3491F, -0.1396F, -0.1745F));
        rFLeg03.addChild("rFLeg2", ModelPartBuilder.create().uv(117, 108).cuboid(-0.5F, -0.7F, -3.0F, 1.0F, 2.0F, 3.0F), ModelTransform.of(-0.7F, 12.9F, -0.5F, 0.3491F, 0.2443F, -0.0524F));
        rFLeg03.addChild("rFLegSpur", ModelPartBuilder.create().uv(95, 63).cuboid(0.0F, -4.0F, 0.0F, 0.0F, 8.0F, 5.0F), ModelTransform.of(0.0F, 4.4F, 0.0F, 0.0F, 0.0F, 0.0F));
        ModelPartData head = chest.addChild("head", ModelPartBuilder.create().uv(53, 0).cuboid(-6.0F, -14.0F, -5.0F, 12.0F, 15.0F, 10.0F), ModelTransform.of(0.0F, -8.9F, 0.0F, 0.0F, 0.0F, 0.0F));
        head.addChild("hoodLTop", ModelPartBuilder.create().uv(42, 29).cuboid(-5.05F, -4.0F, -5.4F, 6.0F, 2.0F, 12.0F), ModelTransform.of(3.65F, -10.9F, 0.0F, 0.0F, 0.0F, 0.3142F));
        head.addChild("hoodRTop", ModelPartBuilder.create().uv(42, 29).mirrored(true).cuboid(-0.95F, -4.0F, -5.41F, 6.0F, 2.0F, 12.0F), ModelTransform.of(-3.65F, -10.9F, 0.0F, 0.0F, 0.0F, -0.3142F));
        head.addChild("hoodLSide01", ModelPartBuilder.create().uv(66, 32).cuboid(0.0F, -0.3F, -5.29F, 2.0F, 9.0F, 12.0F), ModelTransform.of(4.2F, -13.5F, -0.2F, 0.0F, 0.0F, -0.192F));
        head.addChild("hoodRSide01", ModelPartBuilder.create().uv(66, 32).mirrored(true).cuboid(-2.0F, -0.3F, -5.29F, 2.0F, 9.0F, 12.0F), ModelTransform.of(-4.2F, -13.5F, -0.2F, 0.0F, 0.0F, 0.192F));
        head.addChild("hoodLSide02", ModelPartBuilder.create().uv(89, 23).cuboid(-1.2F, -0.4F, -5.45F, 2.0F, 8.0F, 12.0F), ModelTransform.of(6.9F, -5.3F, -0.1F, 0.0F, 0.0F, 0.1309F));
        head.addChild("hoodRSide02", ModelPartBuilder.create().uv(89, 23).mirrored(true).cuboid(-0.8F, -0.4F, -5.45F, 2.0F, 8.0F, 12.0F), ModelTransform.of(-6.9F, -5.3F, -0.1F, 0.0F, 0.0F, -0.1309F));
        ModelPartData hoodPipe01 = head.addChild("hoodPipe01", ModelPartBuilder.create().uv(98, 0).cuboid(-3.5F, -3.5F, -1.1F, 7.0F, 7.0F, 6.0F), ModelTransform.of(0.0F, -10.0F, 5.2F, -0.3142F, -0.3142F, -0.7854F));
        hoodPipe01.addChild("hoodPipe02", ModelPartBuilder.create().uv(108, 13).cuboid(-2.5F, -2.5F, 1.0F, 5.0F, 5.0F, 4.0F), ModelTransform.of(0.0F, -0.3F, 3.1F, -0.2182F, -0.2182F, 0.0F));
        head.addChild("lEye", ModelPartBuilder.create().uv(107, 63).cuboid(-2.0F, -4.0F, -2.5F, 5.0F, 7.0F, 5.0F), ModelTransform.of(3.4F, -7.7F, -2.8F, 0.0F, 0.0F, 0.0F));
        head.addChild("rEye", ModelPartBuilder.create().uv(107, 63).mirrored(true).cuboid(-3.0F, -4.0F, -2.5F, 5.0F, 7.0F, 5.0F), ModelTransform.of(-3.4F, -7.7F, -2.8F, 0.0F, 0.0F, 0.0F));
        head.addChild("hoodBack", ModelPartBuilder.create().uv(94, 44).cuboid(-7.0F, 0.0F, 0.0F, 14.0F, 17.0F, 2.0F), ModelTransform.of(0.0F, -13.7F, 4.5F, 0.1047F, 0.0F, 0.0F));
        ModelPartData lAntenna01 = head.addChild("lAntenna01", ModelPartBuilder.create().uv(43, 0).mirrored(true).cuboid(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 3.0F), ModelTransform.of(2.0F, -12.9F, -4.6F, -0.6109F, -0.4363F, 0.1309F));
        ModelPartData lAntenna02 = lAntenna01.addChild("lAntenna02", ModelPartBuilder.create().uv(44, 0).mirrored(true).cuboid(-0.5F, -0.5F, -3.4F, 1.0F, 1.0F, 4.0F), ModelTransform.of(0.0F, 0.0F, -2.4F, -0.3142F, 0.0F, 0.0F));
        ModelPartData lAntenna03 = lAntenna02.addChild("lAntenna03", ModelPartBuilder.create().uv(43, 0).mirrored(true).cuboid(-0.5F, -0.6F, -3.4F, 1.0F, 1.0F, 4.0F), ModelTransform.of(0.0F, 0.0F, -3.7F, -0.3142F, 0.0F, 0.0F));
        ModelPartData lAntenna04 = lAntenna03.addChild("lAntenna04", ModelPartBuilder.create().uv(43, 0).mirrored(true).cuboid(-0.5F, -0.5F, -5.5F, 1.0F, 1.0F, 6.0F), ModelTransform.of(0.0F, -0.2F, -3.7F, -0.4363F, 0.0F, 0.0F));
        ModelPartData lAntenna05 = lAntenna04.addChild("lAntenna05", ModelPartBuilder.create().uv(43, 0).mirrored(true).cuboid(-0.5F, -0.5F, -2.6F, 1.0F, 1.0F, 3.0F), ModelTransform.of(0.0F, -0.2F, -5.6F, -0.5236F, 0.0F, 0.0F));
        lAntenna05.addChild("lAntenna06", ModelPartBuilder.create().uv(43, 1).mirrored(true).cuboid(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 3.0F), ModelTransform.of(0.0F, -0.2F, -2.8F, -0.5236F, 0.0F, 0.0F));
        ModelPartData rAntenna01 = head.addChild("rAntenna01", ModelPartBuilder.create().uv(43, 0).cuboid(-1.0F, -1.0F, -2.5F, 2.0F, 2.0F, 3.0F), ModelTransform.of(-2.0F, -12.9F, -4.6F, -0.6109F, 0.4363F, -0.1309F));
        ModelPartData rAntenna02 = rAntenna01.addChild("rAntenna02", ModelPartBuilder.create().uv(44, 0).cuboid(-0.5F, -0.5F, -3.4F, 1.0F, 1.0F, 4.0F), ModelTransform.of(0.0F, 0.0F, -2.4F, -0.3142F, 0.0F, 0.0F));
        ModelPartData rAntenna03 = rAntenna02.addChild("rAntenna03", ModelPartBuilder.create().uv(43, 0).cuboid(-0.5F, -0.6F, -3.4F, 1.0F, 1.0F, 4.0F), ModelTransform.of(0.0F, 0.0F, -3.7F, -0.3142F, 0.0F, 0.0F));
        ModelPartData rAntenna04 = rAntenna03.addChild("rAntenna04", ModelPartBuilder.create().uv(43, 0).cuboid(-0.5F, -0.5F, -5.5F, 1.0F, 1.0F, 6.0F), ModelTransform.of(0.0F, -0.2F, -3.7F, -0.4363F, 0.0F, 0.0F));
        ModelPartData rAntenna05 = rAntenna04.addChild("rAntenna05", ModelPartBuilder.create().uv(43, 0).cuboid(-0.5F, -0.5F, -2.6F, 1.0F, 1.0F, 3.0F), ModelTransform.of(0.0F, -0.2F, -5.6F, -0.5236F, 0.0F, 0.0F));
        rAntenna05.addChild("rAntenna06", ModelPartBuilder.create().uv(43, 1).cuboid(-0.5F, -0.5F, -2.5F, 1.0F, 1.0F, 3.0F), ModelTransform.of(0.0F, -0.2F, -2.8F, -0.5236F, 0.0F, 0.0F));
        chest.addChild("chestCloth", ModelPartBuilder.create().uv(0, 21).cuboid(-7.5F, 0.0F, -5.5F, 15.0F, 6.0F, 11.0F), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        ModelPartData lArm01 = chest.addChild("lArm01", ModelPartBuilder.create().uv(45, 44).cuboid(-2.5F, -0.5F, -2.5F, 5.0F, 10.0F, 5.0F), ModelTransform.of(6.8F, -8.0F, 0.0F, 0.0F, 0.0F, -0.2793F));
        ModelPartData lArm02 = lArm01.addChild("lArm02", ModelPartBuilder.create().uv(42, 62).cuboid(-2.5F, 0.0F, -4.7F, 5.0F, 12.0F, 5.0F), ModelTransform.of(0.4F, 8.8F, 2.3F, 0.0F, 0.0F, 0.2269F));
        ModelPartData lSleeve01 = lArm02.addChild("lSleeve01", ModelPartBuilder.create().uv(61, 54).cuboid(-2.4F, -1.5F, 0.2F, 5.0F, 3.0F, 5.0F), ModelTransform.of(0.0F, 10.5F, -0.4F, -0.6981F, 0.0F, 0.0F));
        lSleeve01.addChild("lSleeve02", ModelPartBuilder.create().uv(66, 67).cuboid(-2.0F, -3.4F, -4.5F, 4.0F, 4.0F, 6.0F), ModelTransform.of(0.0F, -0.2F, 0.9F, -0.7854F, 0.0F, 0.0F));
        ModelPartData lArm03 = lArm02.addChild("lArm03", ModelPartBuilder.create().uv(0, 82).cuboid(-1.0F, 0.0F, -1.5F, 2.0F, 13.0F, 3.0F), ModelTransform.of(0.0F, 11.8F, -1.9F, 0.0F, 0.0F, 0.0F));
        lArm03.addChild("lClaw01", ModelPartBuilder.create().cuboid(-0.5F, 0.0F, -1.0F, 1.0F, 4.0F, 2.0F), ModelTransform.of(0.6F, 12.4F, -1.1F, 0.2618F, -0.829F, 0.1309F));
        lArm03.addChild("lClaw02", ModelPartBuilder.create().cuboid(-0.5F, 0.0F, -1.0F, 1.0F, 4.0F, 2.0F), ModelTransform.of(0.6F, 12.4F, 0.7F, 0.2618F, -1.7453F, 0.0F));
        ModelPartData rArm01 = chest.addChild("rArm01", ModelPartBuilder.create().uv(45, 44).mirrored(true).cuboid(-2.5F, -0.5F, -2.5F, 5.0F, 10.0F, 5.0F), ModelTransform.of(-6.8F, -8.0F, 0.0F, 0.0F, 0.0F, 0.2793F));
        ModelPartData rArm02 = rArm01.addChild("rArm02", ModelPartBuilder.create().uv(42, 62).mirrored(true).cuboid(-2.5F, 0.0F, -4.7F, 5.0F, 12.0F, 5.0F), ModelTransform.of(-0.4F, 8.8F, 2.3F, 0.0F, 0.0F, -0.2269F));
        ModelPartData rSleeve01 = rArm02.addChild("rSleeve01", ModelPartBuilder.create().uv(61, 54).mirrored(true).cuboid(-2.6F, -1.5F, 0.2F, 5.0F, 3.0F, 5.0F), ModelTransform.of(0.0F, 10.5F, -0.4F, -0.6981F, 0.0F, 0.0F));
        rSleeve01.addChild("rSleeve02", ModelPartBuilder.create().uv(66, 67).mirrored(true).cuboid(-2.0F, -3.4F, -4.5F, 4.0F, 4.0F, 6.0F), ModelTransform.of(0.0F, -0.2F, 0.9F, -0.7854F, 0.0F, 0.0F));
        ModelPartData rArm03 = rArm02.addChild("rArm03", ModelPartBuilder.create().uv(0, 82).mirrored(true).cuboid(-1.0F, 0.0F, -1.5F, 2.0F, 13.0F, 3.0F), ModelTransform.of(0.0F, 11.8F, -1.9F, 0.0F, 0.0F, 0.0F));
        rArm03.addChild("rClaw01", ModelPartBuilder.create().mirrored(true).cuboid(-0.5F, 0.0F, -1.0F, 1.0F, 4.0F, 2.0F), ModelTransform.of(-0.6F, 12.4F, -1.1F, 0.2618F, 0.829F, -0.1309F));
        rArm03.addChild("rClaw02", ModelPartBuilder.create().mirrored(true).cuboid(-0.5F, 0.0F, -1.0F, 1.0F, 4.0F, 2.0F), ModelTransform.of(-0.6F, 12.4F, 0.7F, 0.2618F, 1.7453F, 0.0F));
        ModelPartData lWing01 = chest.addChild("lWing01", ModelPartBuilder.create().uv(34, 111).mirrored(true).cuboid(-1.0F, -1.4F, 0.0F, 3.0F, 11.0F, 2.0F), ModelTransform.of(4.6F, -5.4F, 4.9F, 0.1047F, 0.0349F, -0.6545F));
        ModelPartData lWing02 = lWing01.addChild("lWing02", ModelPartBuilder.create().uv(45, 111).mirrored(true).cuboid(-1.0F, 0.1F, -0.5F, 2.0F, 15.0F, 1.0F), ModelTransform.of(0.8F, 9.2F, 1.0F, 0.0F, 0.0F, 0.0873F));
        lWing02.addChild("lWing03", ModelPartBuilder.create().uv(54, 111).mirrored(true).cuboid(-1.0F, 0.1F, -0.49F, 2.0F, 15.0F, 1.0F), ModelTransform.of(0.0F, 14.6F, 0.0F, 0.0F, 0.0F, 0.1484F));
        lWing01.addChild("lWingMembrane", ModelPartBuilder.create().uv(66, 82).mirrored(true).cuboid(-17.9F, -1.5F, 0.6F, 20.0F, 45.0F, 0.0F), ModelTransform.of(-0.8F, 0.0F, 0.5F, 0.0F, 0.0F, 0.1047F));
        ModelPartData lWingLower01 = chest.addChild("lWingLower01", ModelPartBuilder.create().uv(34, 111).mirrored(true).cuboid(-1.0F, -1.4F, 0.0F, 3.0F, 11.0F, 2.0F), ModelTransform.of(4.6F, -2.4F, 4.4F, 0.1047F, 0.0349F, -0.3927F));
        ModelPartData lWingLower02 = lWingLower01.addChild("lWingLower02", ModelPartBuilder.create().uv(45, 111).mirrored(true).cuboid(-1.0F, 0.1F, -0.5F, 2.0F, 15.0F, 1.0F), ModelTransform.of(0.8F, 9.2F, 1.0F, 0.0F, 0.0F, 0.0873F));
        lWingLower02.addChild("lWingLower03", ModelPartBuilder.create().uv(54, 111).mirrored(true).cuboid(-1.0F, 0.1F, -0.49F, 2.0F, 15.0F, 1.0F), ModelTransform.of(0.0F, 14.6F, 0.0F, 0.0F, 0.0F, 0.1484F));
        lWingLower01.addChild("lWingLowerMemebrane", ModelPartBuilder.create().uv(66, 82).mirrored(true).cuboid(-17.9F, -1.5F, 0.6F, 20.0F, 45.0F, 0.0F), ModelTransform.of(-0.8F, 0.0F, 0.5F, 0.0F, 0.0F, 0.1047F));
        ModelPartData rWingLower01 = chest.addChild("rWingLower01", ModelPartBuilder.create().uv(34, 111).cuboid(-2.0F, -1.4F, 0.0F, 3.0F, 11.0F, 2.0F), ModelTransform.of(-4.6F, -2.4F, 4.4F, 0.1047F, -0.0349F, 0.3927F));
        ModelPartData rWingLower02 = rWingLower01.addChild("rWingLower02", ModelPartBuilder.create().uv(45, 111).cuboid(-1.0F, 0.1F, -0.5F, 2.0F, 15.0F, 1.0F), ModelTransform.of(-0.8F, 9.2F, 1.0F, 0.0F, 0.0F, -0.0873F));
        rWingLower02.addChild("rWingLower03", ModelPartBuilder.create().uv(54, 111).cuboid(-1.0F, 0.1F, -0.49F, 2.0F, 15.0F, 1.0F), ModelTransform.of(0.0F, 14.6F, 0.0F, 0.0F, 0.0F, -0.1484F));
        rWingLower01.addChild("rWingLowerMemebrane", ModelPartBuilder.create().uv(66, 82).cuboid(-2.1F, -1.5F, 0.6F, 20.0F, 45.0F, 0.0F), ModelTransform.of(0.8F, 0.0F, 0.5F, 0.0F, 0.0F, -0.1047F));
        ModelPartData rWing01 = chest.addChild("rWing01", ModelPartBuilder.create().uv(34, 111).cuboid(-2.0F, -1.4F, 0.0F, 3.0F, 11.0F, 2.0F), ModelTransform.of(-4.6F, -5.4F, 4.9F, 0.1047F, -0.0349F, 0.6545F));
        ModelPartData rWing02 = rWing01.addChild("rWing02", ModelPartBuilder.create().uv(45, 111).cuboid(-1.0F, 0.1F, -0.5F, 2.0F, 15.0F, 1.0F), ModelTransform.of(-0.8F, 9.2F, 1.0F, 0.0F, 0.0F, -0.0873F));
        rWing02.addChild("rWing03", ModelPartBuilder.create().uv(54, 111).cuboid(-1.0F, 0.1F, -0.49F, 2.0F, 15.0F, 1.0F), ModelTransform.of(0.0F, 14.6F, 0.0F, 0.0F, 0.0F, -0.1484F));
        rWing01.addChild("rWingMembrane", ModelPartBuilder.create().uv(66, 82).cuboid(-2.1F, -1.5F, 0.6F, 20.0F, 45.0F, 0.0F), ModelTransform.of(0.8F, 0.0F, 0.5F, 0.0F, 0.0F, -0.1047F));
        return TexturedModelData.of(data, 128, 128);
    }

    @Override
    public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        realArm = false;
        super.setAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        realArm = true;
        copyRotation(lArm01, super.leftArm);
        lArm01.pitch /= 3;
        lArm01.pitch -= 0.1745f;
        lArm01.yaw -= 0.0873f;
        lArm01.roll -= 0.2356f;
        copyRotation(rArm01, super.rightArm);
        rArm01.pitch /= 3;
        rArm01.pitch -= 0.1745f;
        rArm01.yaw += 0.0873f;
        rArm01.roll += 0.2356f;
        this.rBLeg01.pitch = MathHelper.cos(limbSwing * 0.6662F) * 0.3F * limbSwingAmount;
        this.lBLeg01.pitch = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 0.3F * limbSwingAmount;
        this.rFLeg01.pitch = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 0.3F * limbSwingAmount;
        this.lFLeg01.pitch = MathHelper.cos(limbSwing * 0.6662F) * 0.3F * limbSwingAmount;
        if (entity.hurtTime > 0) {
            lWing01.pitch = 0.0873f + (1 + MathHelper.sin(ageInTicks)) / 8;
            rWing01.pitch = 0.0873f + (1 + MathHelper.sin(ageInTicks)) / 8;
            lWingLower01.yaw = 0.0349F + (1 + MathHelper.sin(ageInTicks)) / 8;
            rWingLower01.yaw = -0.0349F - (1 + MathHelper.sin(ageInTicks)) / 8;
        } else {
            lWing01.pitch = 0.0873f + (1 + MathHelper.sin(ageInTicks / 12)) / 8; //adjust values
            rWing01.pitch = 0.0873f + (1 + MathHelper.sin(ageInTicks / 12)) / 8;
            lWingLower01.yaw = 0.0349F + (1 + MathHelper.sin(ageInTicks / 12)) / 8;
            rWingLower01.yaw = -0.0349F - (1 + MathHelper.sin(ageInTicks / 12)) / 8;
        }
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        chest.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    protected ModelPart getArm(Arm arm) {
        return this.realArm ? (arm == Arm.LEFT ? this.lArm01 : this.rArm01) : super.getArm(arm);
    }

    public void setRotationAngle(ModelPart bone, float x, float y, float z) {
        bone.pitch = x;
        bone.yaw = y;
        bone.roll = z;
    }

    private void copyRotation(ModelPart to, ModelPart from) {
        to.pitch = from.pitch;
        to.yaw = from.yaw;
        to.roll = from.roll;
    }
}
