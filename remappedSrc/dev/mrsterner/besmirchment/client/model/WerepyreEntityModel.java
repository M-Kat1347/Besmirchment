// Made with Model Converter by Globox_Z
// Generate all required imports
package dev.mrsterner.besmirchment.client.model;
import dev.mrsterner.besmirchment.common.entity.WerepyreEntity;
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
    public final ModelPart neck;
    public final ModelPart body;
    private final ModelPart tail01;
    private final ModelPart lWing01;
    private final ModelPart lWingMembrane01;
    private final ModelPart lWingMembrane02;
    private final ModelPart lWing02;
    private final ModelPart lWing03;
    private final ModelPart lWing04;
    private final ModelPart lWing05;
    private final ModelPart rWing01;
    private final ModelPart rWingMembrane01;
    private final ModelPart rWingMembrane02;
    private final ModelPart rWing02;
    private final ModelPart rWing03;
    private final ModelPart rWing04;
    private final ModelPart rWing05;
    private final ModelPart lLeg01;
    private final ModelPart rLeg01;
    public final ModelPart lArm01;
    public final ModelPart rArm01;
    private boolean realArm = false;
    public WerepyreEntityModel(ModelPart root) {
        super(root);
        this.neck = root.getChild("neck");
        this.body = root.getChild("body");
        this.tail01 = body.getChild("stomach").getChild("tail01");
        this.lWing01 = body.getChild("lWing01");
        this.lWingMembrane01 = lWing01.getChild("lWingMembrane01");
        this.lWing02 = lWing01.getChild("lWing02");
        this.lWingMembrane02 = lWing02.getChild("lWingMembrane02");
        this.lWing03 = lWing02.getChild("lWing03");
        this.lWing04 = lWing03.getChild("lWing04");
        this.lWing05 = lWing04.getChild("lWing05");
        this.rWing01 = body.getChild("rWing01");
        this.rWingMembrane01 = rWing01.getChild("rWingMembrane01");
        this.rWing02 = rWing01.getChild("rWing02");
        this.rWingMembrane02 = rWing02.getChild("rWingMembrane02");
        this.rWing03 = rWing02.getChild("rWing03");
        this.rWing04 = rWing03.getChild("rWing04");
        this.rWing05 = rWing04.getChild("rWing05");
        this.lLeg01 = body.getChild("stomach").getChild("lLeg01");
        this.rLeg01 = body.getChild("stomach").getChild("rLeg01");
        this.lArm01 = root.getChild("lArm01");
        this.rArm01 = root.getChild("rArm01");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData data = BipedEntityModel.getModelData(Dilation.NONE, 0);
        ModelPartData root = data.getRoot();
        ModelPartData body = root.addChild("body",
        ModelPartBuilder.create()
        .uv(49, 15).cuboid(-5.5F, /*-11.6F*/-3.3F, /*8.5F*/-2.0F, 11.0F, 11.0F, 8.0F),
        ModelTransform.of(0.0F, -0F, 0.0F, 0.5672F, 0.0F, 0.0F));
        body.addChild("head",
        ModelPartBuilder.create()
        .uv(1, 2).cuboid(-0.5F, 0.7F, -0.4F, 1.0F, 1.0F, 1.0F),
        ModelTransform.of(0.0F, -2.0F, 2.0F, 0.0F, 0.0F, 0.0F));
        ModelPartData stomach = body.addChild("stomach",
        ModelPartBuilder.create()
        .uv(16, 16).cuboid(-5.0F, 0.0F/*-11.6F*/, -3.0F, 10.0F, 12.0F, 6.0F),
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
        ModelPartData lArm01 = root.addChild("lArm01",
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
        ModelPartData rArm01 = root.addChild("rArm01",
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
        ModelPartData neck = root.addChild("neck",
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

        return TexturedModelData.of(data,128,128);

    }
    @Override
    public void setAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
/*
        this.body.pitch = 0.5672F;
        this.tail01.pitch = 0.1047F;
        this.lWing01.pitch = -0.2618F;
        this.lWing01.yaw = 0.5236F;
        this.lWing01.roll = -0.2618F;
        this.lWing02.pitch = 1.3526F;
        this.lWing03.pitch = -0.1222F;
        this.lWing04.pitch = -1.0472F;
        this.lWing05.pitch = -0.6981F;
        this.lWingMembrane02.pitch = -1.5795F;
        this.lWingMembrane01.pitch = -0.3491F;
        this.rWing01.pitch = -0.2618F;
        this.rWing01.yaw = -0.5236F;
        this.rWing01.roll = 0.2618F;
        this.rWing02.pitch = 1.3526F;
        this.rWing03.pitch = -0.1222F;
        this.rWing04.pitch = -1.0472F;
        this.rWing05.pitch = -0.6981F;
        this.rWingMembrane02.pitch = -1.5795F;
        this.rWingMembrane01.pitch = -0.3491F;
        this.neck.pitch = -0.2531F;
        this.lArm01.pitch = 0.1745F;
        this.lArm01.yaw = -0.0873F;
        this.lArm01.roll = -0.2356F;
        this.rArm01.pitch = 0.1745F;
        this.rArm01.yaw = 0.0873F;
        this.rArm01.roll = 0.2356F;

 */

        realArm = false;
        super.setAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        realArm = true;
        copyRotation(neck, super.head);
        neck.setPivot(0, -18.2f, -1);
        neck.pitch -= 0.2531f;
        copyRotation(body, super.body);
        body.setPivot(0, -12.7f, 0);
        body.pitch += 0.5672f;
        copyRotation(lArm01, super.leftArm);
        lArm01.setPivot(5.5f, -15, 2);
        lArm01.pitch += 0.1745f;
        lArm01.yaw -= 0.0873f;
        lArm01.roll -= 0.2356f;
        copyRotation(rArm01, super.rightArm);
        rArm01.setPivot(-5.5f, -15, 2);
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
        neck.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        lArm01.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        rArm01.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
       // matrixStack.translate(0F,-0.85F,0F);
        body.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);

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