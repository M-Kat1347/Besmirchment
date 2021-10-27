// Made with Model Converter by Globox_Z
// Generate all required imports
// Made with Blockbench 3.7.5
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports
package de.aelpecyem.besmirchment.client.model;

import de.aelpecyem.besmirchment.common.entity.WerepyreEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Arm;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class WerepyreEntityModel<T extends WerepyreEntity> extends BipedEntityModel<T> {
    private final ModelPart neck;
    private final ModelPart body;
    private final ModelPart tail01;
    private final ModelPart lWing01;
    private final ModelPart lWingMembrane01;
    private final ModelPart lWingMembrane02;
    //private final ModelPart lWingMembrane03;
    private final ModelPart lWing02;
    private final ModelPart lWing03;
    private final ModelPart lWing04;
    private final ModelPart lWing05;
    private final ModelPart rWing01;
    private final ModelPart rWingMembrane01;
    private final ModelPart rWingMembrane02;
    //private final ModelPart rWingMembrane03;
    private final ModelPart rWing02;
    private final ModelPart rWing03;
    private final ModelPart rWing04;
    private final ModelPart rWing05;
    private final ModelPart lLeg01;
    private final ModelPart rLeg01;
    private final ModelPart lArm01;
    private final ModelPart rArm01;
    /*
    private final ModelPart stomach;
    private final ModelPart head;
    private final ModelPart tail02;
    private final ModelPart tail03;
    private final ModelPart tail04;
    private final ModelPart fur01;
    private final ModelPart fur02;
    private final ModelPart fur03;
    private final ModelPart fur04;
    private final ModelPart fur05;
    private final ModelPart fur06;
    private final ModelPart lWingFur2;
    private final ModelPart lWingFur01;
    private final ModelPart lLeg02;
    private final ModelPart rWingFur02;
    private final ModelPart rWingFur01;
    private final ModelPart lLeg03;
    private final ModelPart lFoot;
    private final ModelPart lFootClaw01;
    private final ModelPart lFootClaw02;
    private final ModelPart lFootClaw03;
    private final ModelPart rLeg02;
    private final ModelPart rLeg03;
    private final ModelPart rFoot;
    private final ModelPart rFootClaw01;
    private final ModelPart rFootClaw02;
    private final ModelPart rFootClaw03;
    private final ModelPart head2;
    private final ModelPart jawUpperLeft;
    private final ModelPart upperTeethLeft01;
    private final ModelPart upperTeethLeft02;
    private final ModelPart jawUpperRight;
    private final ModelPart upperTeethRight;
    private final ModelPart jawLower;
    private final ModelPart lowerTeeth01;
    private final ModelPart lowerTeeth02;
    private final ModelPart lEar01;
    private final ModelPart lEar02;
    private final ModelPart rEar01;
    private final ModelPart rEar02;
    private final ModelPart lCheekFur;
    private final ModelPart rCheekFur;
    private final ModelPart snout;
    private final ModelPart lArm02;
    private final ModelPart lArmFur;
    private final ModelPart lClawJoint;
    private final ModelPart lClaw01;
    private final ModelPart lClaw02;
    private final ModelPart lClaw03;
    private final ModelPart rArm02;
    private final ModelPart rArmFur;
    private final ModelPart rClawJoint;
    private final ModelPart rClaw01;
    private final ModelPart rClaw02;
    private final ModelPart rClaw03;

     */

    private boolean realArm = false;

    public WerepyreEntityModel(ModelPart root) {
        super(root);
        this.neck = root.getChild("neck");
        this.body = root.getChild("body");
        this.tail01 = root.getChild("tail01");
        this.lWing01 = root.getChild("lWing01");
        this.lWingMembrane01 = root.getChild("lWingMembrane01");
        this.lWingMembrane02 = root.getChild("lWingMembrane02");
        this.lWing02 = root.getChild("lWing02");
        this.lWing03 = root.getChild("lWing03");
        this.lWing04 = root.getChild("lWing04");
        this.lWing05 = root.getChild("lWing05");
        this.rWing01 = root.getChild("rWing01");
        this.rWingMembrane01 = root.getChild("rWingMembrane01");
        this.rWingMembrane02 = root.getChild("rWingMembrane02");
        this.rWing02 = root.getChild("rWing02");
        this.rWing03 = root.getChild("rWing03");
        this.rWing04 = root.getChild("rWing04");
        this.rWing05 = root.getChild("rWing05");
        this.lLeg01 = root.getChild("lLeg01");
        this.rLeg01 = root.getChild("rLeg01");
        this.lArm01 = root.getChild("lArm01");
        this.rArm01 = root.getChild("rArm01");
/*
        this.stomach = this.body.getChild("stomach");
        this.head = this.body.getChild("head");
        this.tail02 = this.tail01.getChild("tail02");
        this.tail03 = this.tail02.getChild("tail03");
        this.tail04 = this.tail03.getChild("tail04");
        this.fur06 = this.stomach.getChild("fur06");
        this.fur05 = this.stomach.getChild("fur05");

        this.fur04 = this.body.getChild("fur04");
        this.fur03 = this.body.getChild("fur03");
        this.fur02 = this.body.getChild("fur02");

        this.lWingMembrane03 = this.lWing04.getChild("lWingMembrane03");
        this.lWingFur2 = this.lWing02.getChild("lWingFur2");
        this.lWingFur01 = this.lWing01.getChild("lWingFur01");
        this.rWingMembrane03 = this.rWing04.getChild("rWingMembrane03");
        this.rWingFur02 = this.rWing02.getChild("rWingFur02");
        this.rWingFur01 = this.rWing01.getChild("rWingFur01");
        this.lLeg02 = this.lLeg01.getChild("lLeg02");
        this.lLeg03 = this.lLeg02.getChild("lLeg03");
        this.lFoot = this.lLeg03.getChild("lFoot");

        this.lFootClaw01 = this.lFoot.getChild("lFootClaw01");
        this.lFootClaw02 = this.lFoot.getChild("lFootClaw02");
        this.lFootClaw03 = this.lFoot.getChild("lFootClaw03");

        this.rLeg02 = this.rLeg01.getChild("rLeg02");
        this.rLeg03 = this.rLeg02.getChild("rLeg03");
        this.rFoot = this.rLeg03.getChild("rFoot");
        this.rFootClaw01 = this.rFoot.getChild("rFootClaw01");
        this.rFootClaw02 = this.rFoot.getChild("rFootClaw02");
        this.rFootClaw03 = this.rFoot.getChild("rFootClaw03");
        this.head2 = this.neck.getChild("head2");
        this.jawUpperLeft = this.head2.getChild("jawUpperLeft");
        this.upperTeethLeft01 = this.jawUpperLeft.getChild("upperTeethLeft01");
        this.upperTeethLeft02 = this.jawUpperLeft.getChild("upperTeethLeft02");
        this.jawUpperRight = this.head2.getChild("jawUpperRight");
        this.upperTeethRight = this.jawUpperRight.getChild("upperTeethRight");
        this.jawLower = this.head2.getChild("jawLower");
        this.lowerTeeth01 = this.jawLower.getChild("lowerTeeth01");
        this.lowerTeeth02 = this.lowerTeeth01.getChild("lowerTeeth02");

        this.lEar01 = this.head2.getChild("lEar01");
        this.lEar02 = this.lEar01.getChild("lEar02");
        this.rEar01 = this.head2.getChild("rEar01");
        this.rEar02 = this.rEar01.getChild("rEar02");
        this.lCheekFur = this.head2.getChild("lCheekFur");
        this.rCheekFur = this.head2.getChild("rCheekFur");
        this.snout = this.head2.getChild("snout");
        this.fur01 = this.neck.getChild("fur01");
        this.lArm02 = this.lArm01.getChild("lArm02");
        this.lArmFur = this.lArm02.getChild("lArmFur");
        this.lClawJoint = this.lArm02.getChild("lClawJoint");
        this.lClaw01 = this.lClawJoint.getChild("lClaw01");
        this.lClaw02 = this.lClawJoint.getChild("lClaw02");
        this.lClaw03 = this.lClawJoint.getChild("lClaw03");
        this.rArm02 = this.rArm01.getChild("rArm02");
        this.rArmFur = this.rArm02.getChild("rArmFur");
        this.rClawJoint = this.rArm02.getChild("rClawJoint");
        this.rClaw01 = this.rClawJoint.getChild("rClaw01");
        this.rClaw02 = this.rClawJoint.getChild("rClaw02");
        this.rClaw03 = this.rClawJoint.getChild("rClaw03");

 */

    }

    public static TexturedModelData getTexturedModelData() {

        ModelData data = BipedEntityModel.getModelData(Dilation.NONE, 0);
        ModelPartData modelPartData = data.getRoot();
        ModelPartData body = modelPartData.addChild("body",
        ModelPartBuilder.create()
        .uv(49, 15).cuboid(-5.5F, -3.3F, -2.0F, 11.0F, 11.0F, 8.0F),
        ModelTransform.of(0.0F, -12.7F, 0.0F, 0.5672F, 0.0F, 0.0F));
        body.addChild("head",
        ModelPartBuilder.create()
        .uv(1, 2).cuboid(-0.5F, 0.7F, -0.4F, 1.0F, 1.0F, 1.0F),
        ModelTransform.of(0.0F, -2.0F, 2.0F, 0.0F, 0.0F, 0.0F));
        ModelPartData stomach = body.addChild("stomach",
        ModelPartBuilder.create()
        .uv(16, 16).cuboid(-5.0F, 0.0F, -3.0F, 10.0F, 12.0F, 6.0F),
        ModelTransform.of(0.0F, 6.9F, 2.6F, -0.3927F, 0.0F, 0.0F));
        ModelPartData tail01 = stomach.addChild("tail01",
        ModelPartBuilder.create()
        .uv(112, 18).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F),
        ModelTransform.of(0.0F, 8.6F, 2.0F, 0.1047F, 0.0F, 0.0F));
        ModelPartData tail02 = tail01.addChild("tail02",
        ModelPartBuilder.create()
        .uv(115, 27).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F),
        ModelTransform.of(0.0F, 3.7F, 0.0F, -0.2094F, 0.0F, 0.0F));
        ModelPartData tail03 = tail02.addChild("tail03",
        ModelPartBuilder.create()
        .uv(112, 40).cuboid(-1.5F, 0.2F, -1.5F, 3.0F, 4.0F, 3.0F, new Dilation(-0.2F, -0.2F, -0.2F)),
        ModelTransform.of(0.0F, 6.5F, 0.1F, 0.1396F, 0.0F, 0.0F));
        tail03.addChild("tail04",
        ModelPartBuilder.create()
        .uv(116, 7).cuboid(-1.0F, 0.0F, -2.0F, 2.0F, 7.0F, 2.0F, new Dilation(-0.1F, -0.1F, -0.1F)),
        ModelTransform.of(0.0F, 0.0F, 0.4F, 0.0698F, 0.0F, 0.0F));
        stomach.addChild("fur06",
        ModelPartBuilder.create()
        .uv(90, 52).cuboid(-2.0F, -1.0F, 0.0F, 4.0F, 5.0F, 2.0F),
        ModelTransform.of(0.0F, 6.6F, 1.5F, 0.6981F, 0.0F, 0.0F));
        stomach.addChild("fur05",
        ModelPartBuilder.create()
        .uv(90, 43).cuboid(-2.0F, -1.0F, 0.0F, 4.0F, 5.0F, 2.0F),
        ModelTransform.of(0.0F, 4.7F, 1.6F, 0.6981F, 0.0F, 0.0F));
        ModelPartData lLeg01 = stomach.addChild("lLeg01",
        ModelPartBuilder.create()
        .uv(11, 46).cuboid(-2.3F, -1.1F, -1.9F, 5.0F, 13.0F, 5.0F),
        ModelTransform.of(2.7F, 10.2F, -0.4F, 0.0F, 0.0F, 0.0F));
        ModelPartData lLeg02 = lLeg01.addChild("lLeg02",
        ModelPartBuilder.create()
        .uv(0, 35).cuboid(-2.01F, 0.4F, -2.0F, 4.0F, 7.0F, 4.0F),
        ModelTransform.of(0.0F, 9.8F, 0.5F, 1.309F, -0.0524F, 0.0F));
        ModelPartData lLeg03 = lLeg02.addChild("lLeg03",
        ModelPartBuilder.create()
        .uv(0, 22).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 10.0F, 3.0F),
        ModelTransform.of(0.0F, 5.9F, 0.8F, -0.7854F, 0.0F, 0.0873F));
        ModelPartData lFoot = lLeg03.addChild("lFoot",
        ModelPartBuilder.create()
        .uv(0, 14).cuboid(-2.0F, 0.0F, -2.8F, 4.0F, 2.0F, 5.0F),
        ModelTransform.of(0.0F, 8.7F, -1.2F, 0.1309F, 0.0436F, -0.0087F));
        lFoot.addChild("lFootClaw01",
        ModelPartBuilder.create()
        .uv(1, 48).cuboid(-0.5F, -0.5F, -1.7F, 1.0F, 2.0F, 3.0F),
        ModelTransform.of(-1.3F, 0.5F, -2.6F, 0.2269F, 0.1047F, 0.0F));
        lFoot.addChild("lFootClaw02",
        ModelPartBuilder.create()
        .uv(1, 48).cuboid(-0.5F, -0.5F, -1.7F, 1.0F, 2.0F, 3.0F),
        ModelTransform.of(0.0F, 0.5F, -2.6F, 0.2269F, 0.0F, 0.0F));
        lFoot.addChild("lFootClaw03",
        ModelPartBuilder.create()
        .uv(1, 48).cuboid(-0.5F, -0.5F, -1.7F, 1.0F, 2.0F, 3.0F),
        ModelTransform.of(1.3F, 0.5F, -2.6F, 0.2269F, -0.1047F, 0.0F));
        ModelPartData rLeg01 = stomach.addChild("rLeg01",
        ModelPartBuilder.create()
        .uv(11, 46).mirrored(true).cuboid(-2.7F, -1.1F, -1.9F, 5.0F, 13.0F, 5.0F),
        ModelTransform.of(-2.7F, 10.2F, -0.4F, 0.0F, 0.0F, 0.0F));
        ModelPartData rLeg02 = rLeg01.addChild("rLeg02",
        ModelPartBuilder.create()
        .uv(0, 35).mirrored(true).cuboid(-1.99F, 0.4F, -2.0F, 4.0F, 7.0F, 4.0F),
        ModelTransform.of(0.0F, 9.8F, 0.5F, 1.309F, 0.0524F, 0.0F));
        ModelPartData rLeg03 = rLeg02.addChild("rLeg03",
        ModelPartBuilder.create()
        .uv(0, 22).mirrored(true).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 10.0F, 3.0F),
        ModelTransform.of(0.0F, 5.9F, 0.8F, -0.7854F, 0.0F, -0.0873F));
        ModelPartData rFoot = rLeg03.addChild("rFoot",
        ModelPartBuilder.create()
        .uv(0, 14).mirrored(true).cuboid(-2.0F, 0.0F, -2.8F, 4.0F, 2.0F, 5.0F),
        ModelTransform.of(0.0F, 8.7F, -1.2F, 0.1309F, -0.0436F, 0.0087F));
        rFoot.addChild("rFootClaw01",
        ModelPartBuilder.create()
        .uv(1, 48).mirrored(true).cuboid(-0.5F, -0.5F, -1.7F, 1.0F, 2.0F, 3.0F),
        ModelTransform.of(1.3F, 0.5F, -2.6F, 0.2269F, -0.1047F, 0.0F));
        rFoot.addChild("rFootClaw02",
        ModelPartBuilder.create()
        .uv(1, 48).mirrored(true).cuboid(-0.5F, -0.5F, -1.7F, 1.0F, 2.0F, 3.0F),
        ModelTransform.of(0.0F, 0.5F, -2.6F, 0.2269F, 0.0F, 0.0F));
        rFoot.addChild("rFootClaw03",
        ModelPartBuilder.create()
        .uv(1, 48).mirrored(true).cuboid(-0.5F, -0.5F, -1.7F, 1.0F, 2.0F, 3.0F),
        ModelTransform.of(-1.3F, 0.5F, -2.6F, 0.2269F, 0.1047F, 0.0F));
        body.addChild("fur04",
        ModelPartBuilder.create()
        .uv(90, 35).cuboid(-2.5F, -1.0F, 0.0F, 5.0F, 4.0F, 2.0F),
        ModelTransform.of(0.0F, -0.3F, 4.9F, 0.4363F, 0.0F, 0.0F));
        body.addChild("fur03",
        ModelPartBuilder.create()
        .uv(90, 24).cuboid(-4.0F, -1.0F, 0.0F, 8.0F, 7.0F, 2.0F),
        ModelTransform.of(0.0F, -3.6F, 4.5F, 0.6807F, 0.0F, 0.0F));
        body.addChild("fur02",
        ModelPartBuilder.create()
        .uv(90, 11).cuboid(-5.0F, -1.0F, 0.0F, 10.0F, 8.0F, 2.0F),
        ModelTransform.of(0.0F, -4.7F, 3.4F, 1.0908F, 0.0F, 0.0F));
        ModelPartData lWing01 = body.addChild("lWing01",
        ModelPartBuilder.create()
        .uv(78, 99).cuboid(-1.7F, -0.5F, -1.1F, 2.0F, 4.0F, 9.0F),
        ModelTransform.of(2.5F, 1.2F, 6.4F, -0.2618F, 0.5236F, -0.2618F));
        ModelPartData lWing02 = lWing01.addChild("lWing02",
        ModelPartBuilder.create()
        .uv(93, 114).cuboid(-1.7243F, -1.5568F, -1.8828F, 2.0F, 3.0F, 11.0F),
        ModelTransform.of(0.346F, 0.3487F, 9.1164F, 1.3526F, 0.0F, 0.0F));
        ModelPartData lWing03 = lWing02.addChild("lWing03",
        ModelPartBuilder.create()
        .uv(108, 99).cuboid(-1.7F, -0.7F, -1.9F, 2.0F, 13.0F, 3.0F),
        ModelTransform.of(0.1F, -0.5F, 9.1F, -0.1222F, 0.0F, 0.0F));
        ModelPartData lWing04 = lWing03.addChild("lWing04",
        ModelPartBuilder.create()
        .uv(118, 99).cuboid(-1.2F, -0.4F, -0.9F, 1.0F, 17.0F, 2.0F),
        ModelTransform.of(0.0F, 11.7F, 0.0F, -1.0472F, 0.0F, 0.0F));
        lWing04.addChild("lWing05",
        ModelPartBuilder.create()
        .uv(124, 99).cuboid(-0.3F, -1.0F, -1.0F, 1.0F, 15.0F, 1.0F),
        ModelTransform.of(-0.7F, 17.0F, 0.0F, -0.6981F, 0.0F, 0.0F));
        lWing04.addChild("lWingMembrane03",
        ModelPartBuilder.create()
        .uv(0, 62).cuboid(-0.6F, -9.6F, -29.5F, 0.0F, 37.0F, 29.0F),
        ModelTransform.of(0.0F, 7.7F, -0.4F, 0.0F, 0.0F, 0.0F));
        lWing02.addChild("lWingMembrane02",
        ModelPartBuilder.create()
        .uv(54, 38).cuboid(-0.554F, -2.2513F, -13.2836F, 0.0F, 30.0F, 25.0F),
        ModelTransform.of(-0.046F, 0.5513F, 7.4836F, -1.5795F, 0.0F, 0.0F));
        lWing02.addChild("lWingFur2",
        ModelPartBuilder.create()
        .uv(90, 24).cuboid(-4.5F, 0.0F, -2.0F, 8.0F, 7.0F, 2.0F),
        ModelTransform.of(-2.1F, 0.3F, 2.7F, 0.0F, -1.5272F, 0.2182F));
        lWing01.addChild("lWingMembrane01",
        ModelPartBuilder.create()
        .uv(0, 50).cuboid(-0.7F, -9.2F, 0.6F, 0.0F, 22.0F, 16.0F),
        ModelTransform.of(0.0F, 5.9F, -5.0F, -0.3491F, 0.0F, 0.0F));
        lWing01.addChild("lWingFur01",
        ModelPartBuilder.create()
        .uv(90, 11).cuboid(-7.5F, 1.0F, -2.0F, 10.0F, 8.0F, 2.0F),
        ModelTransform.of(-2.0F, 1.5F, 7.1F, 0.0F, -1.5272F, 0.2182F));
        ModelPartData rWing01 = body.addChild("rWing01",
        ModelPartBuilder.create()
        .uv(78, 99).mirrored(true).cuboid(-0.3F, -0.5F, -1.1F, 2.0F, 4.0F, 9.0F),
        ModelTransform.of(-2.5F, 1.2F, 6.4F, -0.2618F, -0.5236F, 0.2618F));
        ModelPartData rWing02 = rWing01.addChild("rWing02",
        ModelPartBuilder.create()
        .uv(93, 114).mirrored(true).cuboid(-0.2757F, -1.5568F, -1.8828F, 2.0F, 3.0F, 11.0F),
        ModelTransform.of(-0.346F, 0.3487F, 9.1164F, 1.3526F, 0.0F, 0.0F));
        ModelPartData rWing03 = rWing02.addChild("rWing03",
        ModelPartBuilder.create()
        .uv(108, 99).mirrored(true).cuboid(-0.3F, -0.7F, -1.9F, 2.0F, 13.0F, 3.0F),
        ModelTransform.of(-0.1F, -0.5F, 9.1F, -0.1222F, 0.0F, 0.0F));
        ModelPartData rWing04 = rWing03.addChild("rWing04",
        ModelPartBuilder.create()
        .uv(118, 99).mirrored(true).cuboid(0.2F, -0.4F, -0.9F, 1.0F, 17.0F, 2.0F),
        ModelTransform.of(0.0F, 11.7F, 0.0F, -1.0472F, 0.0F, 0.0F));
        rWing04.addChild("rWing05",
        ModelPartBuilder.create()
        .uv(124, 99).mirrored(true).cuboid(-0.7F, -1.0F, -1.0F, 1.0F, 15.0F, 1.0F),
        ModelTransform.of(0.7F, 17.0F, 0.0F, -0.6981F, 0.0F, 0.0F));
        rWing04.addChild("rWingMembrane03",
        ModelPartBuilder.create()
        .uv(0, 62).mirrored(true).cuboid(0.6F, -9.6F, -29.5F, 0.0F, 37.0F, 29.0F),
        ModelTransform.of(0.0F, 7.7F, -0.4F, 0.0F, 0.0F, 0.0F));
        rWing02.addChild("rWingMembrane02",
        ModelPartBuilder.create()
        .uv(54, 38).mirrored(true).cuboid(0.554F, -2.2513F, -13.2836F, 0.0F, 30.0F, 25.0F),
        ModelTransform.of(0.046F, 0.5513F, 7.4836F, -1.5795F, 0.0F, 0.0F));
        rWing02.addChild("rWingFur02",
        ModelPartBuilder.create()
        .uv(90, 24).mirrored(true).cuboid(-3.5F, 0.0F, -2.0F, 8.0F, 7.0F, 2.0F),
        ModelTransform.of(2.1F, 0.3F, 2.7F, 0.0F, 1.5272F, -0.2182F));
        rWing01.addChild("rWingMembrane01",
        ModelPartBuilder.create()
        .uv(0, 50).mirrored(true).cuboid(0.7F, -9.2F, 0.6F, 0.0F, 22.0F, 16.0F),
        ModelTransform.of(0.0F, 5.9F, -5.0F, -0.3491F, 0.0F, 0.0F));
        rWing01.addChild("rWingFur01",
        ModelPartBuilder.create()
        .uv(90, 11).mirrored(true).cuboid(-2.5F, 1.0F, -2.0F, 10.0F, 8.0F, 2.0F),
        ModelTransform.of(2.0F, 1.5F, 7.1F, 0.0F, 1.5272F, -0.2182F));
        ModelPartData lArm01 = modelPartData.addChild("lArm01",
        ModelPartBuilder.create()
        .uv(32, 47).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F),
        ModelTransform.of(5.5F, -15.0F, 2.0F, 0.1745F, -0.0873F, -0.2356F));
        ModelPartData lArm02 = lArm01.addChild("lArm02",
        ModelPartBuilder.create()
        .uv(49, 46).cuboid(-1.5F, -1.0F, -1.5F, 3.0F, 13.0F, 3.0F),
        ModelTransform.of(0.0F, 11.5F, 0.0F, -0.5236F, 0.0F, 0.1484F));
        lArm02.addChild("lArmFur",
        ModelPartBuilder.create()
        .uv(62, 50).cuboid(-0.5F, -0.5F, 1.5F, 1.0F, 8.0F, 4.0F),
        ModelTransform.of(0.4F, -4.0F, 0.0F, -0.4363F, 0.0873F, 0.0873F));
        ModelPartData lClawJoint = lArm02.addChild("lClawJoint",
        ModelPartBuilder.create()
        .cuboid(-0.4F, 1.5F, -0.5F, 1.0F, 1.0F, 1.0F),
        ModelTransform.of(0.0F, 8.6F, 0.0F, 0.0F, 0.0F, 0.0F));
        lClawJoint.addChild("lClaw01",
        ModelPartBuilder.create()
        .uv(27, 0).cuboid(-1.4F, 1.2F, -1.6F, 2.0F, 5.0F, 1.0F),
        ModelTransform.of(1.0F, 0.2F, 0.0F, -0.1047F, 0.0F, 0.2269F));
        lClawJoint.addChild("lClaw02",
        ModelPartBuilder.create()
        .uv(27, 0).cuboid(-1.4F, 1.2F, -0.5F, 2.0F, 5.0F, 1.0F),
        ModelTransform.of(1.0F, 0.2F, -0.1F, 0.0F, 0.0F, 0.2269F));
        lClawJoint.addChild("lClaw03",
        ModelPartBuilder.create()
        .uv(27, 0).cuboid(-1.4F, 1.2F, -0.5F, 2.0F, 5.0F, 1.0F),
        ModelTransform.of(1.0F, 0.2F, 0.8F, 0.1047F, 0.0F, 0.2269F));
        ModelPartData rArm01 = modelPartData.addChild("rArm01",
        ModelPartBuilder.create()
        .uv(32, 47).mirrored(true).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F),
        ModelTransform.of(-5.5F, -15.0F, 2.0F, 0.1745F, 0.0873F, 0.2356F));
        ModelPartData rArm02 = rArm01.addChild("rArm02",
        ModelPartBuilder.create()
        .uv(49, 46).mirrored(true).cuboid(-1.5F, -1.0F, -1.5F, 3.0F, 13.0F, 3.0F),
        ModelTransform.of(0.0F, 11.5F, 0.0F, -0.5236F, 0.0F, -0.1484F));
        rArm02.addChild("rArmFur",
        ModelPartBuilder.create()
        .uv(62, 50).mirrored(true).cuboid(-0.5F, -0.5F, 1.5F, 1.0F, 8.0F, 4.0F),
        ModelTransform.of(-0.4F, -4.0F, 0.0F, -0.4363F, -0.0873F, -0.0873F));
        ModelPartData rClawJoint = rArm02.addChild("rClawJoint",
        ModelPartBuilder.create()
        .mirrored(true).cuboid(-0.6F, 1.5F, -0.5F, 1.0F, 1.0F, 1.0F),
        ModelTransform.of(0.0F, 8.6F, 0.0F, 0.0F, 0.0F, 0.0F));
        rClawJoint.addChild("rClaw01",
        ModelPartBuilder.create()
        .uv(27, 0).mirrored(true).cuboid(-0.6F, 1.2F, -1.6F, 2.0F, 5.0F, 1.0F),
        ModelTransform.of(-1.0F, 0.2F, 0.0F, -0.1047F, 0.0F, -0.2269F));
        rClawJoint.addChild("rClaw02",
        ModelPartBuilder.create()
        .uv(27, 0).mirrored(true).cuboid(-0.6F, 1.2F, -0.5F, 2.0F, 5.0F, 1.0F),
        ModelTransform.of(-1.0F, 0.2F, -0.1F, 0.0F, 0.0F, -0.2269F));
        rClawJoint.addChild("rClaw03",
        ModelPartBuilder.create()
        .uv(27, 0).mirrored(true).cuboid(-0.6F, 1.2F, -0.5F, 2.0F, 5.0F, 1.0F),
        ModelTransform.of(-1.0F, 0.2F, 0.8F, 0.1047F, 0.0F, -0.2269F));
        ModelPartData neck = modelPartData.addChild("neck",
        ModelPartBuilder.create()
        .cuboid(-3.5F, -1.5F, -1.0F, 7.0F, 5.0F, 5.0F),
        ModelTransform.of(0.0F, -18.2F, -1.0F, -0.2531F, 0.0F, 0.0F));
        ModelPartData head2 = neck.addChild("head2",
        ModelPartBuilder.create()
        .uv(44, 0).cuboid(-4.0F, -3.0F, -4.4F, 8.0F, 6.0F, 7.0F),
        ModelTransform.of(0.0F, -0.5F, -3.6F, 1.9199F, 0.0F, 0.0F));
        ModelPartData jawUpperLeft = head2.addChild("jawUpperLeft",
        ModelPartBuilder.create()
        .uv(20, 36).cuboid(-1.1F, -1.0F, -2.0F, 2.0F, 4.0F, 2.0F)
        .uv(69, 42).cuboid(-0.11F, -0.7F, -4.1F, 1.0F, 2.0F, 4.0F),
        ModelTransform.of(1.2F, -5.1F, -1.5F, 0.0F, 0.0F, -0.1396F));
        jawUpperLeft.addChild("upperTeethLeft01",
        ModelPartBuilder.create()
        .uv(56, 37).cuboid(-0.6F, 2.0F, -1.8F, 1.0F, 4.0F, 2.0F),
        ModelTransform.of(0.4F, -2.8F, -1.0F, 0.0F, 0.0F, 0.0F));
        jawUpperLeft.addChild("upperTeethLeft02",
        ModelPartBuilder.create()
        .uv(63, 38).cuboid(-2.27F, 2.4F, -1.4F, 3.0F, 0.0F, 1.0F),
        ModelTransform.of(0.0F, -3.2F, -1.0F, 0.0F, 0.0F, 0.1367F));
        ModelPartData jawUpperRight = head2.addChild("jawUpperRight",
        ModelPartBuilder.create()
        .uv(20, 36).mirrored(true).cuboid(-0.9F, -1.0F, -2.0F, 2.0F, 4.0F, 2.0F)
        .uv(69, 42).cuboid(-0.81F, -0.7F, -4.1F, 1.0F, 2.0F, 4.0F),
        ModelTransform.of(-1.2F, -5.1F, -1.5F, 0.0F, 0.0F, 0.1396F));
        jawUpperRight.addChild("upperTeethRight",
        ModelPartBuilder.create()
        .uv(56, 37).mirrored(true).cuboid(-0.4F, 2.0F, -1.8F, 1.0F, 4.0F, 2.0F),
        ModelTransform.of(-0.4F, -2.8F, -1.0F, 0.0F, 0.0F, 0.0F));
        ModelPartData jawLower = head2.addChild("jawLower",
        ModelPartBuilder.create()
        .uv(39, 37).cuboid(-2.0F, -3.9F, -1.5F, 4.0F, 4.0F, 1.0F),
        ModelTransform.of(0.0F, -2.1F, -3.0F, 0.0F, 0.0F, 0.0F));
        ModelPartData lowerTeeth01 = jawLower.addChild("lowerTeeth01",
        ModelPartBuilder.create()
        .uv(63, 41).cuboid(-1.6F, 2.3F, -0.6F, 1.0F, 3.0F, 1.0F),
        ModelTransform.of(0.0F, -5.7F, 0.1F, 0.0F, 0.0F, 0.0F));
        lowerTeeth01.addChild("lowerTeeth02",
        ModelPartBuilder.create()
        .uv(63, 41).cuboid(0.6F, 2.3F, -0.7F, 1.0F, 3.0F, 1.0F),
        ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F));
        ModelPartData lEar01 = head2.addChild("lEar01",
        ModelPartBuilder.create()
        .uv(77, 0).mirrored(true).cuboid(0.0F, -2.0F, -2.6F, 1.0F, 5.0F, 4.0F),
        ModelTransform.of(2.8F, -0.1F, 2.8F, 0.6981F, 0.1222F, -0.6981F));
        lEar01.addChild("lEar02",
        ModelPartBuilder.create()
        .uv(81, 11).mirrored(true).cuboid(-1.4F, 2.0F, -2.4F, 1.0F, 7.0F, 2.0F),
        ModelTransform.of(-0.3F, -3.0F, -0.5F, 0.2269F, 0.0F, -0.2618F));
        ModelPartData rEar01 = head2.addChild("rEar01",
        ModelPartBuilder.create()
        .uv(77, 0).cuboid(-1.0F, -2.0F, -2.6F, 1.0F, 5.0F, 4.0F),
        ModelTransform.of(-2.8F, -0.1F, 2.8F, 0.6981F, -0.1222F, 0.6981F));
        rEar01.addChild("rEar02",
        ModelPartBuilder.create()
        .uv(81, 11).cuboid(0.4F, 2.0F, -2.4F, 1.0F, 7.0F, 2.0F),
        ModelTransform.of(0.3F, -3.0F, -0.5F, 0.2269F, 0.0F, 0.2618F));
        head2.addChild("lCheekFur",
        ModelPartBuilder.create()
        .uv(26, 4).mirrored(true).cuboid(0.0F, -0.8F, -3.3F, 0.0F, 6.0F, 5.0F),
        ModelTransform.of(3.5F, -0.5F, -0.6F, 0.1222F, -0.0873F, -0.5236F));
        head2.addChild("rCheekFur",
        ModelPartBuilder.create()
        .uv(26, 4).cuboid(0.0F, -0.8F, -3.3F, 0.0F, 6.0F, 5.0F),
        ModelTransform.of(-3.5F, -0.5F, -0.6F, 0.1222F, 0.0873F, 0.5236F));
        head2.addChild("snout",
        ModelPartBuilder.create()
        .uv(29, 35).cuboid(-1.5F, -2.2F, -2.0F, 3.0F, 4.0F, 2.0F),
        ModelTransform.of(0.0F, -4.2F, -0.1F, 0.182F, 0.0F, 0.0F));
        neck.addChild("fur01",
        ModelPartBuilder.create()
        .uv(90, 0).cuboid(-3.5F, 2.0F, 0.0F, 7.0F, 7.0F, 2.0F, new Dilation(0.1F, 0.1F, 0.1F)),
        ModelTransform.of(0.0F, 0.0F, -2.9F, 1.9635F, 0.0F, 0.0F));

        modelPartData.addChild("body", ModelPartBuilder.create().uv(49, 15).cuboid(-5.5F, -3.3F, -2.0F, 11.0F, 11.0F, 8.0F), ModelTransform.pivot(0.0F, -12.7F, 0.0F));
        modelPartData.addChild("head", ModelPartBuilder.create().uv(1, 2).cuboid(-0.5F, 0.7F, -0.4F, 1.0F, 1.0F, 1.0F), ModelTransform.pivot(0.0F, -2.0F, 2.0F));
        modelPartData.addChild("stomach", ModelPartBuilder.create().uv(16, 16).cuboid(-5.0F, 0.0F, -3.0F, 10.0F, 12.0F, 6.0F), ModelTransform.pivot(0.0F, 6.9F, 2.6F));
        modelPartData.addChild("tail01", ModelPartBuilder.create().uv(112, 18).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 4.0F, 3.0F), ModelTransform.pivot(0.0F, 8.6F, 2.0F));
        modelPartData.addChild("tail02", ModelPartBuilder.create().uv(115, 27).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F), ModelTransform.pivot(0.0F, 3.7F, 0.0F));
        modelPartData.addChild("tail03", ModelPartBuilder.create().uv(112, 40).cuboid(-1.5F, 0.2F, -1.5F, 3.0F, 4.0F, 3.0F, new Dilation(-0.2F)), ModelTransform.pivot(0.0F, 6.5F, 0.1F));
        modelPartData.addChild("tail04", ModelPartBuilder.create().uv(116, 7).cuboid(-1.0F, 0.0F, -2.0F, 2.0F, 7.0F, 2.0F, new Dilation(-0.1F)), ModelTransform.pivot(0.0F, 0.0F, 0.4F));
        modelPartData.addChild("fur06", ModelPartBuilder.create().uv(90, 52).cuboid(-2.0F, -1.0F, 0.0F, 4.0F, 5.0F, 2.0F), ModelTransform.pivot(0.0F, 6.6F, 1.5F));
        modelPartData.addChild("fur05", ModelPartBuilder.create().uv(90, 43).cuboid(-2.0F, -1.0F, 0.0F, 4.0F, 5.0F, 2.0F), ModelTransform.pivot(0.0F, 4.7F, 1.6F));
        modelPartData.addChild("fur04", ModelPartBuilder.create().uv(90, 35).cuboid(-2.5F, -1.0F, 0.0F, 5.0F, 4.0F, 2.0F), ModelTransform.pivot(0.0F, -0.3F, 4.9F));
        modelPartData.addChild("fur03", ModelPartBuilder.create().uv(90, 24).cuboid(-4.0F, -1.0F, 0.0F, 8.0F, 7.0F, 2.0F), ModelTransform.pivot(0.0F, -3.6F, 4.5F));
        modelPartData.addChild("fur02", ModelPartBuilder.create().uv(90, 11).cuboid(-5.0F, -1.0F, 0.0F, 10.0F, 8.0F, 2.0F), ModelTransform.pivot(0.0F, -4.7F, 3.4F));
        modelPartData.addChild("lWing01", ModelPartBuilder.create().uv(78, 99).cuboid(-1.7F, -0.5F, -1.1F, 2.0F, 4.0F, 9.0F), ModelTransform.pivot(2.5F, 1.2F, 6.4F));
        modelPartData.addChild("lWing02", ModelPartBuilder.create().uv(93, 114).cuboid(-1.7243F, -1.5568F, -1.8828F, 2.0F, 3.0F, 11.0F), ModelTransform.pivot(0.346F, 0.3487F, 9.1164F));
        modelPartData.addChild("lWing03", ModelPartBuilder.create().uv(108, 99).cuboid(-1.7F, -0.7F, -1.9F, 2.0F, 13.0F, 3.0F), ModelTransform.pivot(0.1F, -0.5F, 9.1F));
        modelPartData.addChild("lWing04", ModelPartBuilder.create().uv(118, 99).cuboid(-1.2F, -0.4F, -0.9F, 1.0F, 17.0F, 2.0F), ModelTransform.pivot(0.0F, 11.7F, 0.0F));
        modelPartData.addChild("lWing05", ModelPartBuilder.create().uv(124, 99).cuboid(-0.3F, -1.0F, -1.0F, 1.0F, 15.0F, 1.0F), ModelTransform.pivot(-0.7F, 17.0F, 0.0F));
        modelPartData.addChild("lWingMembrane03", ModelPartBuilder.create().uv(0, 62).cuboid(-0.6F, -9.6F, -29.5F, 0.0F, 37.0F, 29.0F), ModelTransform.pivot(0.0F, 7.7F, -0.4F));
        modelPartData.addChild("lWingMembrane02", ModelPartBuilder.create().uv(54, 38).cuboid(-0.554F, -2.2513F, -13.2836F, 0.0F, 30.0F, 25.0F), ModelTransform.pivot(-0.046F, 0.5513F, 7.4836F));
        modelPartData.addChild("lWingFur2", ModelPartBuilder.create().uv(90, 24).cuboid(-4.5F, 0.0F, -2.0F, 8.0F, 7.0F, 2.0F), ModelTransform.pivot(-2.1F, 0.3F, 2.7F));
        modelPartData.addChild("lWingMembrane01", ModelPartBuilder.create().uv(0, 50).cuboid(-0.7F, -9.2F, 0.6F, 0.0F, 22.0F, 16.0F), ModelTransform.pivot(0.0F, 5.9F, -5.0F));
        modelPartData.addChild("lWingFur01", ModelPartBuilder.create().uv(90, 11).cuboid(-7.5F, 1.0F, -2.0F, 10.0F, 8.0F, 2.0F), ModelTransform.pivot(-2.0F, 1.5F, 7.1F));
        modelPartData.addChild("rWing01", ModelPartBuilder.create().uv(78, 99).cuboid(-0.3F, -0.5F, -1.1F, 2.0F, 4.0F, 9.0F, true), ModelTransform.pivot(-2.5F, 1.2F, 6.4F));
        modelPartData.addChild("rWing02", ModelPartBuilder.create().uv(93, 114).cuboid(-0.2757F, -1.5568F, -1.8828F, 2.0F, 3.0F, 11.0F, true), ModelTransform.pivot(-0.346F, 0.3487F, 9.1164F));
        modelPartData.addChild("rWing03", ModelPartBuilder.create().uv(108, 99).cuboid(-0.3F, -0.7F, -1.9F, 2.0F, 13.0F, 3.0F, true), ModelTransform.pivot(-0.1F, -0.5F, 9.1F));
        modelPartData.addChild("rWing04", ModelPartBuilder.create().uv(118, 99).cuboid(0.2F, -0.4F, -0.9F, 1.0F, 17.0F, 2.0F, true), ModelTransform.pivot(0.0F, 11.7F, 0.0F));
        modelPartData.addChild("rWing05", ModelPartBuilder.create().uv(124, 99).cuboid(-0.7F, -1.0F, -1.0F, 1.0F, 15.0F, 1.0F, true), ModelTransform.pivot(0.7F, 17.0F, 0.0F));
        modelPartData.addChild("rWingMembrane03", ModelPartBuilder.create().uv(0, 62).cuboid(0.6F, -9.6F, -29.5F, 0.0F, 37.0F, 29.0F, true), ModelTransform.pivot(0.0F, 7.7F, -0.4F));
        modelPartData.addChild("rWingMembrane02", ModelPartBuilder.create().uv(54, 38).cuboid(0.554F, -2.2513F, -13.2836F, 0.0F, 30.0F, 25.0F, true), ModelTransform.pivot(0.046F, 0.5513F, 7.4836F));
        modelPartData.addChild("rWingFur02", ModelPartBuilder.create().uv(90, 24).cuboid(-3.5F, 0.0F, -2.0F, 8.0F, 7.0F, 2.0F, true), ModelTransform.pivot(2.1F, 0.3F, 2.7F));
        modelPartData.addChild("rWingMembrane01", ModelPartBuilder.create().uv(0, 50).cuboid(0.7F, -9.2F, 0.6F, 0.0F, 22.0F, 16.0F, true), ModelTransform.pivot(0.0F, 5.9F, -5.0F));
        modelPartData.addChild("rWingFur01", ModelPartBuilder.create().uv(90, 11).cuboid(-2.5F, 1.0F, -2.0F, 10.0F, 8.0F, 2.0F, true), ModelTransform.pivot(2.0F, 1.5F, 7.1F));
        modelPartData.addChild("lLeg01", ModelPartBuilder.create().uv(11, 46).cuboid(-2.3F, -1.1F, -1.9F, 5.0F, 13.0F, 5.0F), ModelTransform.pivot(2.7F, 10.2F, -0.4F));
        modelPartData.addChild("lLeg02", ModelPartBuilder.create().uv(0, 35).cuboid(-2.01F, 0.4F, -2.0F, 4.0F, 7.0F, 4.0F), ModelTransform.pivot(0.0F, 9.8F, 0.5F));
        modelPartData.addChild("lLeg03", ModelPartBuilder.create().uv(0, 22).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 10.0F, 3.0F), ModelTransform.pivot(0.0F, 5.9F, 0.8F));
        modelPartData.addChild("lFoot", ModelPartBuilder.create().uv(0, 14).cuboid(-2.0F, 0.0F, -2.8F, 4.0F, 2.0F, 5.0F), ModelTransform.pivot(0.0F, 8.7F, -1.2F));
        modelPartData.addChild("lFootClaw01", ModelPartBuilder.create().uv(1, 48).cuboid(-0.5F, -0.5F, -1.7F, 1.0F, 2.0F, 3.0F), ModelTransform.pivot(-1.3F, 0.5F, -2.6F));
        modelPartData.addChild("lFootClaw02", ModelPartBuilder.create().uv(1, 48).cuboid(-0.5F, -0.5F, -1.7F, 1.0F, 2.0F, 3.0F), ModelTransform.pivot(0.0F, 0.5F, -2.6F));
        modelPartData.addChild("lFootClaw03", ModelPartBuilder.create().uv(1, 48).cuboid(-0.5F, -0.5F, -1.7F, 1.0F, 2.0F, 3.0F), ModelTransform.pivot(1.3F, 0.5F, -2.6F));
        modelPartData.addChild("rLeg01", ModelPartBuilder.create().uv(11, 46).cuboid(-2.7F, -1.1F, -1.9F, 5.0F, 13.0F, 5.0F, true), ModelTransform.pivot(-2.7F, 10.2F, -0.4F));
        modelPartData.addChild("rLeg02", ModelPartBuilder.create().uv(0, 35).cuboid(-1.99F, 0.4F, -2.0F, 4.0F, 7.0F, 4.0F, true), ModelTransform.pivot(0.0F, 9.8F, 0.5F));
        modelPartData.addChild("rLeg03", ModelPartBuilder.create().uv(0, 22).cuboid(-1.5F, 0.0F, -1.5F, 3.0F, 10.0F, 3.0F, true), ModelTransform.pivot(0.0F, 5.9F, 0.8F));
        modelPartData.addChild("rFoot", ModelPartBuilder.create().uv(0, 14).cuboid(-2.0F, 0.0F, -2.8F, 4.0F, 2.0F, 5.0F, true), ModelTransform.pivot(0.0F, 8.7F, -1.2F));
        modelPartData.addChild("rFootClaw01", ModelPartBuilder.create().uv(1, 48).cuboid(-0.5F, -0.5F, -1.7F, 1.0F, 2.0F, 3.0F, true), ModelTransform.pivot(1.3F, 0.5F, -2.6F));
        modelPartData.addChild("rFootClaw02", ModelPartBuilder.create().uv(1, 48).cuboid(-0.5F, -0.5F, -1.7F, 1.0F, 2.0F, 3.0F, true), ModelTransform.pivot(0.0F, 0.5F, -2.6F));
        modelPartData.addChild("rFootClaw03", ModelPartBuilder.create().uv(1, 48).cuboid(-0.5F, -0.5F, -1.7F, 1.0F, 2.0F, 3.0F, true), ModelTransform.pivot(-1.3F, 0.5F, -2.6F));
        modelPartData.addChild("neck", ModelPartBuilder.create().uv(0, 0).cuboid(-3.5F, -1.5F, -1.0F, 7.0F, 5.0F, 5.0F), ModelTransform.pivot(0.0F, -18.2F, -1.0F));
        modelPartData.addChild("head2", ModelPartBuilder.create().uv(44, 0).cuboid(-4.0F, -3.0F, -4.4F, 8.0F, 6.0F, 7.0F), ModelTransform.pivot(0.0F, -0.5F, -3.6F));
        modelPartData.addChild("jawUpperLeft", ModelPartBuilder.create().uv(20, 36).cuboid(-1.1F, -1.0F, -2.0F, 2.0F, 4.0F, 2.0F).uv(69, 42).cuboid(-0.11F, -0.7F, -4.1F, 1.0F, 2.0F, 4.0F), ModelTransform.pivot(1.2F, -5.1F, -1.5F));
        modelPartData.addChild("upperTeethLeft01", ModelPartBuilder.create().uv(56, 37).cuboid(-0.6F, 2.0F, -1.8F, 1.0F, 4.0F, 2.0F), ModelTransform.pivot(0.4F, -2.8F, -1.0F));
        modelPartData.addChild("upperTeethLeft02", ModelPartBuilder.create().uv(63, 38).cuboid(-2.27F, 2.4F, -1.4F, 3.0F, 0.0F, 1.0F), ModelTransform.pivot(0.0F, -3.2F, -1.0F));
        modelPartData.addChild("jawUpperRight", ModelPartBuilder.create().uv(20, 36).cuboid(-0.9F, -1.0F, -2.0F, 2.0F, 4.0F, 2.0F, true).uv(69, 42).cuboid(-0.81F, -0.7F, -4.1F, 1.0F, 2.0F, 4.0F, true), ModelTransform.pivot(-1.2F, -5.1F, -1.5F));
        modelPartData.addChild("upperTeethRight", ModelPartBuilder.create().uv(56, 37).cuboid(-0.4F, 2.0F, -1.8F, 1.0F, 4.0F, 2.0F, true), ModelTransform.pivot(-0.4F, -2.8F, -1.0F));
        modelPartData.addChild("jawLower", ModelPartBuilder.create().uv(39, 37).cuboid(-2.0F, -3.9F, -1.5F, 4.0F, 4.0F, 1.0F), ModelTransform.pivot(0.0F, -2.1F, -3.0F));
        modelPartData.addChild("lowerTeeth01", ModelPartBuilder.create().uv(63, 41).cuboid(-1.6F, 2.3F, -0.6F, 1.0F, 3.0F, 1.0F), ModelTransform.pivot(0.0F, -5.7F, 0.1F));
        modelPartData.addChild("lowerTeeth02", ModelPartBuilder.create().uv(63, 41).cuboid(0.6F, 2.3F, -0.7F, 1.0F, 3.0F, 1.0F), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        modelPartData.addChild("lEar01", ModelPartBuilder.create().uv(77, 0).cuboid(0.0F, -2.0F, -2.6F, 1.0F, 5.0F, 4.0F, true), ModelTransform.pivot(2.8F, -0.1F, 2.8F));
        modelPartData.addChild("lEar02", ModelPartBuilder.create().uv(81, 11).cuboid(-1.4F, 2.0F, -2.4F, 1.0F, 7.0F, 2.0F, true), ModelTransform.pivot(-0.3F, -3.0F, -0.5F));
        modelPartData.addChild("rEar01", ModelPartBuilder.create().uv(77, 0).cuboid(-1.0F, -2.0F, -2.6F, 1.0F, 5.0F, 4.0F), ModelTransform.pivot(-2.8F, -0.1F, 2.8F));
        modelPartData.addChild("rEar02", ModelPartBuilder.create().uv(81, 11).cuboid(0.4F, 2.0F, -2.4F, 1.0F, 7.0F, 2.0F), ModelTransform.pivot(0.3F, -3.0F, -0.5F));
        modelPartData.addChild("lCheekFur", ModelPartBuilder.create().uv(26, 4).cuboid(0.0F, -0.8F, -3.3F, 0.0F, 6.0F, 5.0F, true), ModelTransform.pivot(3.5F, -0.5F, -0.6F));
        modelPartData.addChild("rCheekFur", ModelPartBuilder.create().uv(26, 4).cuboid(0.0F, -0.8F, -3.3F, 0.0F, 6.0F, 5.0F), ModelTransform.pivot(-3.5F, -0.5F, -0.6F));
        modelPartData.addChild("snout", ModelPartBuilder.create().uv(29, 35).cuboid(-1.5F, -2.2F, -2.0F, 3.0F, 4.0F, 2.0F), ModelTransform.pivot(0.0F, -4.2F, -0.1F));
        modelPartData.addChild("fur01", ModelPartBuilder.create().uv(90, 0).cuboid(-3.5F, 2.0F, 0.0F, 7.0F, 7.0F, 2.0F, new Dilation(0.1F)), ModelTransform.pivot(0.0F, 0.0F, -2.9F));
        modelPartData.addChild("lArm01", ModelPartBuilder.create().uv(32, 47).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F), ModelTransform.pivot(5.5F, -15.0F, 2.0F));
        modelPartData.addChild("lArm02", ModelPartBuilder.create().uv(49, 46).cuboid(-1.5F, -1.0F, -1.5F, 3.0F, 13.0F, 3.0F), ModelTransform.pivot(0.0F, 11.5F, 0.0F));
        modelPartData.addChild("lArmFur", ModelPartBuilder.create().uv(62, 50).cuboid(-0.5F, -0.5F, 1.5F, 1.0F, 8.0F, 4.0F), ModelTransform.pivot(0.4F, -4.0F, 0.0F));
        modelPartData.addChild("lClawJoint", ModelPartBuilder.create().uv(0, 0).cuboid(-0.4F, 1.5F, -0.5F, 1.0F, 1.0F, 1.0F), ModelTransform.pivot(0.0F, 8.6F, 0.0F));
        modelPartData.addChild("lClaw01", ModelPartBuilder.create().uv(27, 0).cuboid(-1.4F, 1.2F, -1.6F, 2.0F, 5.0F, 1.0F), ModelTransform.pivot(1.0F, 0.2F, 0.0F));
        modelPartData.addChild("lClaw02", ModelPartBuilder.create().uv(27, 0).cuboid(-1.4F, 1.2F, -0.5F, 2.0F, 5.0F, 1.0F), ModelTransform.pivot(1.0F, 0.2F, -0.1F));
        modelPartData.addChild("lClaw03", ModelPartBuilder.create().uv(27, 0).cuboid(-1.4F, 1.2F, -0.5F, 2.0F, 5.0F, 1.0F), ModelTransform.pivot(1.0F, 0.2F, 0.8F));
        modelPartData.addChild("rArm01", ModelPartBuilder.create().uv(32, 47).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, true), ModelTransform.pivot(-5.5F, -15.0F, 2.0F));
        modelPartData.addChild("rArm02", ModelPartBuilder.create().uv(49, 46).cuboid(-1.5F, -1.0F, -1.5F, 3.0F, 13.0F, 3.0F, true), ModelTransform.pivot(0.0F, 11.5F, 0.0F));
        modelPartData.addChild("rArmFur", ModelPartBuilder.create().uv(62, 50).cuboid(-0.5F, -0.5F, 1.5F, 1.0F, 8.0F, 4.0F, true), ModelTransform.pivot(-0.4F, -4.0F, 0.0F));
        modelPartData.addChild("rClawJoint", ModelPartBuilder.create().uv(0, 0).cuboid(-0.6F, 1.5F, -0.5F, 1.0F, 1.0F, 1.0F, true), ModelTransform.pivot(0.0F, 8.6F, 0.0F));
        modelPartData.addChild("rClaw01", ModelPartBuilder.create().uv(27, 0).cuboid(-0.6F, 1.2F, -1.6F, 2.0F, 5.0F, 1.0F, true), ModelTransform.pivot(-1.0F, 0.2F, 0.0F));
        modelPartData.addChild("rClaw02", ModelPartBuilder.create().uv(27, 0).cuboid(-0.6F, 1.2F, -0.5F, 2.0F, 5.0F, 1.0F, true), ModelTransform.pivot(-1.0F, 0.2F, -0.1F));
        modelPartData.addChild("rClaw03", ModelPartBuilder.create().uv(27, 0).cuboid(-0.6F, 1.2F, -0.5F, 2.0F, 5.0F, 1.0F, true), ModelTransform.pivot(-1.0F, 0.2F, 0.8F));
        modelPartData.addChild("neck", ModelPartBuilder.create(), ModelTransform.pivot(0F, -18.2F, 1F));
        modelPartData.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0F, -12.7F, 0F));
        modelPartData.addChild("lArm01", ModelPartBuilder.create(), ModelTransform.pivot(5.5F, 15F, 2F));
        modelPartData.addChild("rArm01", ModelPartBuilder.create(), ModelTransform.pivot(-5.5F, 15F, 2F));






        return TexturedModelData.of(data, 128, 128);

    }

    @Override
    public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.body.pitch = 0.5672F;
        //this.stomach.pitch = -0.3927F;
        this.tail01.pitch = 0.1047F;
/*
        this.tail02.pitch = -0.2094F;
        this.tail03.pitch = 0.1396F;
        this.tail04.pitch = 0.0698F;
        this.fur06.pitch = 0.6981F;
        this.fur05.pitch = 0.6981F;
        this.fur04.pitch = 0.4363F;
        this.fur03.pitch = 0.6807F;
        this.fur02.pitch = 1.0908F;


 */

        this.lWing01.pitch = -0.2618F;
        this.lWing01.yaw = 0.5236F;
        this.lWing01.roll = -0.2618F;
        this.lWing02.pitch = 1.3526F;
        this.lWing03.pitch = -0.1222F;
        this.lWing04.pitch = -1.0472F;
        this.lWing05.pitch = -0.6981F;
        this.lWingMembrane02.pitch = -1.5795F;
/*
        this.lWingFur2.yaw = -1.5272F;
        this.lWingFur2.roll = 0.2182F;


 */

        this.lWingMembrane01.pitch = -0.3491F;
/*
        this.lWingFur01.yaw = -1.5272F;
        this.lWingFur01.roll = 0.2182F;

 */


        this.rWing01.pitch = -0.2618F;
        this.rWing01.yaw = -0.5236F;
        this.rWing01.roll = 0.2618F;
        this.rWing02.pitch = 1.3526F;
        this.rWing03.pitch = -0.1222F;
        this.rWing04.pitch = -1.0472F;
        this.rWing05.pitch = -0.6981F;
        this.rWingMembrane02.pitch = -1.5795F;
/*
        this.rWingFur02.yaw = 1.5272F;
        this.rWingFur02.roll = -0.2182F;


 */

        this.rWingMembrane01.pitch = -0.3491F;
/*
        this.rWingFur01.yaw = 1.5272F;
        this.rWingFur01.roll = -0.2182F;
        this.lLeg02.pitch = 1.309F;
        this.lLeg02.yaw = -0.0524F;
        this.lLeg03.pitch = -0.7854F;
        this.lLeg03.roll = 0.0873F;
        this.lFoot.pitch = 0.1309F;
        this.lFoot.yaw = 0.0436F;
        this.lFoot.roll = -0.0087F;
        this.lFootClaw01.pitch = 0.2269F;
        this.lFootClaw01.yaw = 0.1047F;
        this.lFootClaw02.pitch = 0.2269F;
        this.lFootClaw03.pitch = 0.2269F;
        this.lFootClaw03.yaw = -0.1047F;
        this.rLeg02.pitch = 1.309F;
        this.rLeg02.yaw = 0.0524F;
        this.rLeg03.pitch = -0.7854F;
        this.rLeg03.roll = -0.0873F;
        this.rFoot.pitch = 0.1309F;
        this.rFoot.yaw = -0.0436F;
        this.rFoot.roll = 0.0087F;
        this.rFootClaw01.pitch = 0.2269F;
        this.rFootClaw01.yaw = -0.1047F;
        this.rFootClaw02.pitch = 0.2269F;
        this.rFootClaw03.pitch = 0.2269F;
        this.rFootClaw03.yaw = 0.1047F;


 */

        this.neck.pitch = -0.2531F;
/*
        this.head2.pitch = 1.9199F;
        this.jawUpperLeft.roll = -0.1396F;
        this.upperTeethLeft02.roll = 0.1367F;
        this.jawUpperRight.roll = 0.1396F;
        this.lEar01.pitch = 0.6981F;
        this.lEar01.yaw = 0.1222F;
        this.lEar01.roll = -0.6981F;
        this.lEar02.pitch = 0.2269F;
        this.lEar02.roll = -0.2618F;
        this.rEar01.pitch = 0.6981F;
        this.rEar01.yaw = -0.1222F;
        this.rEar01.roll = 0.6981F;
        this.rEar02.pitch = 0.2269F;
        this.rEar02.roll = 0.2618F;
        this.lCheekFur.pitch = 0.1222F;
        this.lCheekFur.yaw = -0.0873F;
        this.lCheekFur.roll = -0.5236F;
        this.rCheekFur.pitch = 0.1222F;
        this.rCheekFur.yaw = 0.0873F;
        this.rCheekFur.roll = 0.5236F;
        this.snout.pitch = 0.182F;
        this.fur01.pitch = 1.9635F;

 */

        this.lArm01.pitch = 0.1745F;
        this.lArm01.yaw = -0.0873F;
        this.lArm01.roll = -0.2356F;
/*
        this.lArm02.pitch = -0.5236F;
        this.lArm02.roll = 0.1484F;

        this.lArmFur.pitch = -0.4363F;
        this.lArmFur.yaw = 0.0873F;
        this.lArmFur.roll = 0.0873F;
        this.lClaw01.pitch = -0.1047F;
        this.lClaw01.roll = 0.2269F;
        this.lClaw02.roll = 0.2269F;
        this.lClaw03.pitch = 0.1047F;
        this.lClaw03.roll = 0.2269F;

 */


        this.rArm01.pitch = 0.1745F;
        this.rArm01.yaw = 0.0873F;
        this.rArm01.roll = 0.2356F;
/*
        this.rArm02.pitch = -0.5236F;
        this.rArm02.roll = -0.1484F;
        this.rArmFur.pitch = -0.4363F;
        this.rArmFur.yaw = -0.0873F;
        this.rArmFur.roll = -0.0873F;
        this.rClaw01.pitch = -0.1047F;
        this.rClaw01.roll = -0.2269F;
        this.rClaw02.roll = -0.2269F;
        this.rClaw03.pitch = 0.1047F;
        this.rClaw03.roll = -0.2269F;

 */


        realArm = false;
        super.setAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        realArm = true;
        copyRotation(neck, super.head);
        neck.pitch -= 0.2531f;
        copyRotation(body, super.body);
        body.pitch += 0.5672f;
        copyRotation(lArm01, super.leftArm);
        lArm01.pitch += 0.1745f;
        lArm01.yaw -= 0.0873f;
        lArm01.roll -= 0.2356f;
        copyRotation(rArm01, super.rightArm);
        rArm01.pitch += 0.1745f;
        rArm01.yaw += 0.0873f;
        rArm01.roll += 0.2356f;
        copyRotation(lLeg01, super.leftLeg);
        lLeg01.pitch /= 2;
        lLeg01.pitch -= 3 / 4f;
        lLeg01.yaw += -0.2269f;
        lLeg01.roll -= 0.0873f;
        copyRotation(rLeg01, super.rightLeg);
        rLeg01.pitch /= 2;
        rLeg01.pitch -= 3 / 4f;
        rLeg01.yaw -= -0.2269f;
        rLeg01.roll += 0.0873f;
        tail01.roll = MathHelper.sin(ageInTicks / 8) / 8;
        boolean flying = entity.getLastJumpTime() <= 20;
        if (flying) {
            if (entity.jumpBeginProgress < 1) {
                entity.jumpBeginProgress += MinecraftClient.getInstance().getTickDelta() / 10F;
            }
        } else if (entity.jumpBeginProgress > 0) {
            entity.jumpBeginProgress -= MinecraftClient.getInstance().getTickDelta() / 10F;
        }
        lWing01.yaw = MathHelper.lerp(entity.jumpBeginProgress, 0.5236F, 1.0036F);
        rWing01.yaw = MathHelper.lerp(entity.jumpBeginProgress, -0.5236F, -1.0036F);
        lWing02.pitch = MathHelper.lerp(entity.jumpBeginProgress, 1.3526F, 1.0036F);
        rWing02.pitch = MathHelper.lerp(entity.jumpBeginProgress, 1.3526F, 1.0036F);
        lWing03.pitch = MathHelper.lerp(entity.jumpBeginProgress, -0.1222F, 0.9687F);
        rWing03.pitch = MathHelper.lerp(entity.jumpBeginProgress, -0.1222F, 0.9687F);
        lWing04.pitch = MathHelper.lerp(entity.jumpBeginProgress, -1.0472F, -0.2182F);
        rWing04.pitch = MathHelper.lerp(entity.jumpBeginProgress, -1.0472F, -0.2182F);
        lWingMembrane02.pitch = MathHelper.lerp(entity.jumpBeginProgress, -1.5795F, -0.7505F);
        rWingMembrane02.pitch = MathHelper.lerp(entity.jumpBeginProgress, -1.5795F, -0.7505F);
        if (flying) {
            lWing01.yaw += MathHelper.sin(ageInTicks / 1.5F) / 3;
            rWing01.yaw += -MathHelper.sin(ageInTicks / 1.5F) / 3;
        } else {
            lWing01.yaw += MathHelper.sin(ageInTicks / 8) / 8;
            rWing01.yaw += -MathHelper.sin(ageInTicks / 8) / 8;
        }
        if (flying) {
            neck.pivotY += 2;
            neck.pivotZ -= 4;
            body.pivotY += 2;
            body.pivotZ -= 4;
            body.pitch += 0.5f;
            lArm01.pivotY += 2;
            lArm01.pivotZ -= 4;
            rArm01.pivotY += 2;
            rArm01.pivotZ -= 4;
        } else if (entity.isSneaking()) {
            neck.pivotY += 2;
            neck.pivotZ -= 4;
            body.pivotY += 2;
            body.pivotZ -= 4;
            body.pitch += 0.5f;
            lArm01.pivotY += 2;
            lArm01.pivotZ -= 4;
            rArm01.pivotY += 2;
            rArm01.pivotZ -= 4;
            rLeg01.pitch -= 0.5f;
            lLeg01.pitch -= 0.5f;
        }
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        neck.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        lArm01.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        rArm01.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
    }

    public void setRotationAngle(ModelPart bone, float x, float y, float z) {
        bone.pitch = x;
        bone.yaw = y;
        bone.roll = z;
    }

    protected ModelPart getArm(Arm arm) {
        return this.realArm ? (arm == Arm.LEFT ? this.lArm01 : this.rArm01) : super.getArm(arm);
    }

    private void copyRotation(ModelPart to, ModelPart from) {
        to.pitch = from.pitch;
        to.yaw = from.yaw;
        to.roll = from.roll;
    }
}
