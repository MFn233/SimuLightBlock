<p align="center">
  <a href="https://github.com/maple-days"><img src="https://github.com/maple-days.png?size=96" width="56" alt="Maple Days"></a>
</p>

<p align="center">
  <sub><b>Maple Days</b> · 《打脸日常》整合包 mod · Minecraft 1.12.2</sub>
</p>

# SimuLightBlock · Sim-U 灯箱

把 SimuKraft 的灯箱方块移植到 **Minecraft 1.12.2**。

八种颜色、全部 **光照等级 15** 的完整方块，适合做灯箱、招牌底光、柜台照明和装饰点缀。

| 顺序 | 颜色 | 注册名 |
|---|---|---|
| 1 | 白 | `simulightblock:light_block_white` |
| 2 | 红 | `simulightblock:light_block_red` |
| 3 | 橙 | `simulightblock:light_block_orange` |
| 4 | 黄 | `simulightblock:light_block_yellow` |
| 5 | 绿 | `simulightblock:light_block_green` |
| 6 | 蓝 | `simulightblock:light_block_blue` |
| 7 | 紫 | `simulightblock:light_block_purple` |
| 8 | 彩 | `simulightblock:light_block_rainbow` |

物品栏内按 **白 → 红 → 橙 → 黄 → 绿 → 蓝 → 紫 → 彩** 排列（即注册顺序）。彩虹灯箱是 7 帧循环动画，`frametime` 为 4。

## 合成

```
玻璃  玻璃  玻璃
玻璃  染料  玻璃     →  8 个对应颜色的灯箱
玻璃  玻璃  玻璃
```

彩虹灯箱把染料换成**海晶砂粒**（`minecraft:prismarine_crystals`）。

## 兼容性

| 项 | 值 |
|---|---|
| Minecraft | 1.12.2 |
| 加载器 | Forge 14.23.5.2847+ / Cleanroom |
| 运行环境 | 仅客户端需要资源包；服务端装同一个 jar 即可 |
| 前置 | 无 |
| 编译目标 | Java 8 |

## 构建

需要 **JDK 25** 运行 Gradle，编译目标是 Java 8。

```bash
./gradlew build
# 产物：build/libs/simulightblock-<version>.jar
```

在 IDEA 里打开项目时，把 Gradle JVM 设为 JDK 25；编译仍由工具链自动使用 JDK 8。

## 项目结构

```
src/main/java/com/mfn233/simulightblock/
  BlockLightBox.java     灯箱方块（完整立方体 / 光照 15 / 玻璃音效）
  ModBlocks.java         8 种颜色的注册 + ItemBlock 注册
  ClientModels.java      物品模型绑定
  SimuLightBlock.java    @Mod 入口 + 创造模式物品栏
  Tags.java              构建时由 tags.properties 自动生成，不要手写
src/main/resources/assets/simulightblock/
  blockstates/  8 份
  models/block  8 份（cube_all）
  models/item   8 份（继承对应方块模型）
  textures/blocks 8 张 16x16 PNG + 彩虹动画的 .mcmeta
  lang/         zh_cn / en_us
  recipes/      8 份 shaped 配方
```

## 加一种新颜色

1. 在 `ModBlocks.COLORS` 里加名字（顺序即物品栏顺序）
2. 放一张 `textures/blocks/light_block_<name>.png`
3. 用同样的模板生成 `blockstates`、`models/block`、`models/item`、`recipes`
4. 在 `lang/zh_cn.lang` 与 `en_us.lang` 各加一行 `tile.light_block_<name>.name=`

## 实现说明

方块用的是 `Material.ROCK` 加不透明立方体，**不是** `Material.GLASS`：贴图本身不透明，玻璃材质不遮挡光照，会让方块表面发灰、并可能引起面剔除错误。

`mod_icon`（物品栏/模组列表图标）直接取自白色灯箱贴图，放大到 128×128。

## 许可证

- **代码**（1.12.2 移植、注册、配方、语言文件）：**MIT**，Copyright 2026 MFn233
- **材质**（`textures/blocks/light_block_*.png`）：版权归 **Scott Hather**，本项目按署名方式引用，**不因本项目的 MIT 声明而被重新授权**
- **构建脚本**：来自 CleanroomMC 的 [TemplateDevEnv](https://github.com/CleanroomMC/TemplateDevEnv)（MIT）

详见 [LICENSE](LICENSE) 与 [CREDITS.md](CREDITS.md)。