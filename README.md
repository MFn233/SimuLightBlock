# SimuLightBlock

彩色灯箱方块，从 SimuKraft 移植到 Minecraft 1.12.2。

八种颜色：白、红、橙、黄、绿、蓝、紫、彩虹（彩虹为 7 帧循环动画）。全部为**光照等级 15** 的完整方块，适合做灯箱、招牌底光和装饰照明。

## 合成

```
玻璃 玻璃 玻璃
玻璃 染料 玻璃       → 8 个对应颜色的灯箱
玻璃 玻璃 玻璃
```

彩虹灯箱把染料换成**海晶砂粒**。

## 版本

| 项 | 值 |
|---|---|
| Minecraft | 1.12.2 |
| 加载器 | Forge 14.23.5.2847+ / Cleanroom |
| 构建 | Java 8 目标，Gradle 9 + RetroFuturaGradle |
| 许可证 | 代码 MIT；材质署名 Scott Hather（详见 [CREDITS.md](CREDITS.md)） |

## 构建

```bash
./gradlew build
# 产物：build/libs/simulightblock-<version>.jar
```

需要 JDK 25 运行 Gradle，编译目标为 Java 8。

## 开发说明

- 方块与物品注册：`ModBlocks`（`RegistryEvent`）
- 客户端模型：`ClientModels`（`ModelRegistryEvent`）
- 新增颜色：在 `ModBlocks.COLORS` 加一项，并在 `assets/simulightblock` 下补 blockstate / 模型 / 材质 / 语言 / 配方即可