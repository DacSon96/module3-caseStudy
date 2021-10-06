-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: case_study_module_3
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart`
(
    `id`         int NOT NULL AUTO_INCREMENT,
    `productId`  int    DEFAULT NULL,
    `quantity`   int    DEFAULT NULL,
    `totalPrice` double DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY          `productId` (`productId`),
    CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`productId`) REFERENCES `product` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK
TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category`
(
    `id`   int NOT NULL AUTO_INCREMENT,
    `name` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK
TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category`
VALUES (1, 'Shirt'),
       (2, 'Hoodie');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer`
(
    `id`      int NOT NULL AUTO_INCREMENT,
    `name`    varchar(255) DEFAULT NULL,
    `phone`   int          DEFAULT NULL,
    `address` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK
TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `orderdetail`
--

DROP TABLE IF EXISTS `orderdetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderdetail`
(
    `id`         int NOT NULL AUTO_INCREMENT,
    `customerId` int DEFAULT NULL,
    `cartId`     int DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY          `customerId` (`customerId`),
    KEY          `cartId` (`cartId`),
    CONSTRAINT `orderdetail_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `customer` (`id`) ON DELETE SET NULL,
    CONSTRAINT `orderdetail_ibfk_2` FOREIGN KEY (`cartId`) REFERENCES `cart` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetail`
--

LOCK
TABLES `orderdetail` WRITE;
/*!40000 ALTER TABLE `orderdetail` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderdetail` ENABLE KEYS */;
UNLOCK
TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product`
(
    `id`          int NOT NULL AUTO_INCREMENT,
    `name`        varchar(255) DEFAULT NULL,
    `size`        varchar(255) DEFAULT NULL,
    `image`       longtext,
    `price`       double       DEFAULT NULL,
    `categoryId`  int          DEFAULT NULL,
    `description` longtext,
    PRIMARY KEY (`id`),
    KEY           `categoryId` (`categoryId`),
    CONSTRAINT `product_ibfk_1` FOREIGN KEY (`categoryId`) REFERENCES `category` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK
TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product`
VALUES (1, 'Why So Salty T-Shirt', 'XL',
        '//image.spreadshirtmedia.com/image-server/v1/mp/products/T812A2MPA3140PT17X11Y73D1023033403FS3861/views/1,width=550,height=550,appearanceId=2,backgroundColor=F2F2F2,modelId=115,crop=list/why-so-salty-funny-salt-shaker-salty-attitude-mens-premium-t-shirt.jpg',
        19.99, 1,
        'Brand: Soloban || 100% pre-shrunk cotton (heather gray color is 90% cotton/10% polyester || light heather gray is 98% cotton/2% polyester, heather black is 50% cotton/50% polyester) || Fabric Weight: 5.0 oz (mid-weight) || Double-stitched seams at shoulder, sleeve, collar and waist || Special Note: Mineral Wash colors have a slight yellow tint and not one is the same due to the special dye process Imported || processed and printed in the U.S.A.\n'),
       (2, 'Establish My Alibi T-Shirt', 'S',
        '//image.spreadshirtmedia.com/image-server/v1/mp/products/T347A2MPA2978PT17X13Y37D1039007766FS3235/views/1,width=550,height=550,appearanceId=4,backgroundColor=F2F2F2,modelId=2564,crop=list/i-m-just-here-to-establish-my-alibi-funny-saying-womens-t-shirt.jpg',
        18.99, 1,
        'Brand: Sport Tek || 100% pre-shrunk cotton || PosiCharge moisture-wicking materials, roomy and highly breathable || Fabric weight: 3.8 oz (lightweight) || Material: 100% polyester interlock || Imported product, printed & processed in the USA\n'),
       (3, 'Funny Robo Hooide', 'XL',
        '//image.spreadshirtmedia.com/image-server/v1/mp/products/T20A647MPA3631PT17X77Y26D1016929654FS2798/views/1,width=550,height=550,appearanceId=4,backgroundColor=F2F2F2,modelId=2516,crop=list/game-boy-kid-mens-premium-hoodie.jpg',
        37.99, 2,
        '50% cotton / 50% polyester (Heather Gray is 53% polyester/ 47% cotton) || Fabric weight: 5.6oz (heavyweight)Dri-Power, moisture management properties Double-needle stitched hemmed sleeves ad bottom hem Seamless, 1x1 rib collar and body Imported || processed and printed in the U.S.A.'),
       (4, 'My Brain Has Too Many T-Shirt', 'XL',
        '//image.spreadshirtmedia.com/image-server/v1/mp/products/T812A1MPA3140PT17X28Y1D1008163683FS6252/views/1,width=550,height=550,appearanceId=1,backgroundColor=F2F2F2,modelId=115,crop=list/brain-tabs-mens-premium-t-shirt.jpg',
        19.99, 1,
        'Brand: Action Style || Unisex tailoring fits men rather tight and women more loosely (when in doubt, choose a size bigger or smaller)Light, super smooth fabrics 3.8 oz\nMaterial: 50% polyester, 25% cotton, 25% rayon || Imported, processed and printed in the U.S.A.\n'),
       (5, 'Ghost Funny T-Shirt', 'S',
        '//image.spreadshirtmedia.com/image-server/v1/mp/products/T813A2MPA3132PT17X31Y29D1018091611FS3061/views/1,width=550,height=550,appearanceId=2,backgroundColor=F2F2F2,modelId=338,crop=list/faboolous-fabulous-speech-therapist-halloween-tshirt-slp-womens-premium-t-shirt.jpg',
        17.99, 1,
        'Brand: Nice Talk || 100% cotton (heather gray is 95% cotton/5% viscose. heather blue & charcoal gray are 80% cotton/20% polyester. heather burgundy is 60% cotton/40% polyester). | Fabric Weight: 4.42 oz || Fairly produced, certified and triple audited.Double stitched, reinforced seams at shoulder, sleeve, collar and waist\nProduct may run small, please check size chartsImported garment, processed and printed in the U.S.A.\n'),
       (6, 'I Was Like T-Shirt', 'XL',
        '//image.spreadshirtmedia.com/image-server/v1/mp/products/T210A66MPA3176PT17X9Y8D13050700FS3709/views/1,width=550,height=550,appearanceId=66,backgroundColor=F2F2F2,modelId=1543,crop=list/snowmobile-and-i-was-like-bbbraaaap-mens-t-shirt.jpg',
        19.99, 1,
        'Brand: Cadino || 100% pre-shrunk cotton (heather gray color is 90% cotton/10% polyester, light heather gray is 98% cotton/2% polyester, heather black is 50% cotton/50% polyester) | Fabric Weight: 5.0 oz (mid-weight) Double-stitched seams at shoulder, sleeve, collar and waist || Special Note: Mineral Wash colors have a slight yellow tint and not one is the same due to the special dye process Imported || processed and printed in the U.S.A.'),
       (7, 'Wolf Pack Hoodie', 'XL',
        '//image.spreadshirtmedia.com/image-server/v1/mp/products/T111A4MPA3629PT17X26Y0D11475120FS5920/views/1,width=550,height=550,appearanceId=4,backgroundColor=F2F2F2,modelId=1460,crop=list/wolf-pack-member-mens-hoodie.jpg',
        38.99, 2,
        'Brand: Avintex || This premium T-shirt is as close to perfect as can be. It\'s optimized for all types of print and will quickly become your favorite T-shirt. Soft,
        comfortable and durable, this is a definite must-own. || Double stitched,
        reinforced seams at shoulder, sleeve,
        collar and waist || Optimized for beautiful brilliance across all printing methods Imported;
processed
and printed in the U.S.A.'),(8,'And Them Came T-Shirt','S','//image.spreadshirtmedia.com/image-server/v1/mp/products/T347A2MPA2978PT17X0Y0D1016656272FS3551/views/1,width=550,height=550,appearanceId=4,backgroundColor=F2F2F2,modelId=2564,crop=list/taco-tells-scary-campfire-story-about-tuesdays-funny-graphic-womens-t-shirt.jpg',18.99,1,'Brand: Hakentu || One of our faves! Top quality and best results with all print methods
\nClassic round neckline || Very durable fabrics: 5.29 oz || Material: 100% cotton Imported product, printed & processed in the USA'),(9,'T-Rex Hates T-Shirt','XL','//image.spreadshirtmedia.com/image-server/v1/mp/products/T210A2MPA3176PT17X38Y22D12186444FS16575CxFFFFFF:xB5263C/views/1,width=550,height=550,appearanceId=2,backgroundColor=F2F2F2,modelId=1543,crop=list/t-rex-hates-push-ups-mens-t-shirt.jpg',18.99,1,'
50% cotton / 50% polyester (Heather Gray is 53% polyester/ 47% cotton) || Fabric weight: 5.6oz (heavyweight)Dri-Power, moisture management properties Double-needle stitched hemmed sleeves ad bottom hem Seamless, 1x1 rib collar and body Imported || processed and printed in the U.S.A.'),(10,'Road Closed Hoodie','XL','//image.spreadshirtmedia.com/image-server/v1/mp/products/T111A2MPA3629PT17X51Y0D1022281065FS2624/views/1,width=550,height=550,appearanceId=2,backgroundColor=F2F2F2,modelId=1460,crop=list/road-closed-let-s-find-out-why-jeep-mens-hoodie.jpg',36.99,2,'Brand: X-Demon || 100% pre-shrunk cotton (heather gray color is 90% cotton/10% polyester, light heather gray is 98% cotton/2% polyester, heather black is 50% cotton/50% polyester) || Fabric Weight: 5.0 oz (mid-weight) || Double-stitched seams at shoulder, sleeve, collar and waist || Special Note: Mineral Wash colors have a slight yellow tint and not one is the same due to the special dye process
\nImported || processed and printed in the U.S.A.'),(11,'A Journey T-Shirt','XL','//image.spreadshirtmedia.com/image-server/v1/mp/products/T1130A1MPA3365PT17X17Y45D1007342819FS6059/views/1,width=550,height=550,appearanceId=1,backgroundColor=F2F2F2,modelId=1567,crop=list/journey-grunge-unisex-poly-cotton-t-shirt.jpg',19.99,1,'Brand: Soloban || 100% pre-shrunk cotton (heather gray color is 90% cotton/10% polyester || light heather gray is 98% cotton/2% polyester, heather black is 50% cotton/50% polyester) || Fabric Weight: 5.0 oz (mid-weight) || Double-stitched seams at shoulder, sleeve, collar and waist || Special Note: Mineral Wash colors have a slight yellow tint and not one is the same due to the special dye process Imported || processed and printed in the U.S.A.
\n
\n'),(12,'My Spirit Animal T-Shirt','S','//image.spreadshirtmedia.com/image-server/v1/mp/products/T813A2MPA3132PT17X50Y23D13703822FS3893/views/1,width=550,height=550,appearanceId=2,backgroundColor=F2F2F2,modelId=338,crop=list/my-spirit-animal-womens-premium-t-shirt.jpg',17.99,1,'Brand: Sport Tek || 100% pre-shrunk cotton || PosiCharge moisture-wicking materials, roomy and highly breathable || Fabric weight: 3.8 oz (lightweight) || Material: 100% polyester interlock || Imported product, printed & processed in the USA
\n'),(13,'Beautiful Cute T-Shirt','XL','//image.spreadshirtmedia.com/image-server/v1/mp/products/T210A231MPA3176PT17X22Y10D1034840069FS4543/views/1,width=550,height=550,appearanceId=231,backgroundColor=F2F2F2,modelId=1543,crop=list/looney-tunes-marvin-the-martian-mens-t-shirt.jpg',19.99,1,'Brand: Action Style || Unisex tailoring fits men rather tight and women more loosely (when in doubt, choose a size bigger or smaller)Light, super smooth fabrics 3.8 oz
\nMaterial: 50% polyester, 25% cotton, 25% rayon || Imported, processed and printed in the U.S.A.
\n'),(14,'Be Nice T-Shirt','XL','//image.spreadshirtmedia.com/image-server/v1/mp/products/T992A2MPA3591PT17X33Y37D13639278FS3028/views/1,width=550,height=550,appearanceId=2,backgroundColor=F2F2F2,modelId=1189,crop=list/vascular-ultrasound-technologist-maternity-t-shirt.jpg',19.99,1,'Brand: Nice Talk || 100% cotton (heather gray is 95% cotton/5% viscose. heather blue & charcoal gray are 80% cotton/20% polyester. heather burgundy is 60% cotton/40% polyester). | Fabric Weight: 4.42 oz || Fairly produced, certified and triple audited.Double stitched, reinforced seams at shoulder, sleeve, collar and waist
\nProduct may run small, please check size chartsImported garment, processed and printed in the U.S.A.
\n'),(15,'Magic Demon T-Shirt','XL','//image.spreadshirtmedia.com/image-server/v1/mp/products/T210A2MPA3176PT17X0Y21D1033336415FS4704/views/1,width=550,height=550,appearanceId=2,backgroundColor=F2F2F2,modelId=1543,crop=list/harry-potter-the-deathly-hallows-icon-mens-t-shirt.jpg',18.99,1,'Brand: Cadino || 100% pre-shrunk cotton (heather gray color is 90% cotton/10% polyester, light heather gray is 98% cotton/2% polyester, heather black is 50% cotton/50% polyester) | Fabric Weight: 5.0 oz (mid-weight) Double-stitched seams at shoulder, sleeve, collar and waist || Special Note: Mineral Wash colors have a slight yellow tint and not one is the same due to the special dye process Imported || processed and printed in the U.S.A.'),(16,'Sunflow Pink T-Shirt','S','//image.spreadshirtmedia.com/image-server/v1/mp/products/T347A2MPA2978PT17X1Y0D1025657823FS2624/views/1,width=550,height=550,appearanceId=2,backgroundColor=F2F2F2,modelId=2564,crop=list/faith-hope-love-pink-daisy-flower-breast-cancer-womens-t-shirt.jpg',19.99,1,'Brand: Titan Fall || Anti-fading color and print protection || Fabric weight: 3.8 oz (lightweight) || Material: 100% polyester interlock Imported product, printed & processed in the USA'),(17,'BatMan Logo T-Shirt','XL','//image.spreadshirtmedia.com/image-server/v1/mp/products/T1197A2MPA3503PT17X14Y23D1033659643FS6563/views/1,width=550,height=550,appearanceId=2,backgroundColor=F2F2F2,modelId=1970,crop=list/batman-logo-mens-5050-t-shirt.jpg',19.99,1,'Brand: Soloban || 100% pre-shrunk cotton (heather gray color is 90% cotton/10% polyester || light heather gray is 98% cotton/2% polyester, heather black is 50% cotton/50% polyester) || Fabric Weight: 5.0 oz (mid-weight) || Double-stitched seams at shoulder, sleeve, collar and waist || Special Note: Mineral Wash colors have a slight yellow tint and not one is the same due to the special dye process Imported || processed and printed in the U.S.A.'),(18,'New Zealand All Black Hoodie','XL','//image.spreadshirtmedia.com/image-server/v1/mp/products/T111A2MPA3629PT17X73Y14D1014499159FS2900/views/1,width=550,height=550,appearanceId=4,backgroundColor=F2F2F2,modelId=1460,crop=list/new-new-zealand-all-blacks-rugby-mens-hoodie.jpg',39.99,2,'Brand: Avintex || This premium T-shirt is as close to perfect as can be. It
\'s optimized for all types of print and will quickly become your favorite T-shirt. Soft, comfortable and durable, this is a definite must-own. || Double stitched, reinforced seams at shoulder, sleeve, collar and waist || Optimized for beautiful brilliance across all printing methods Imported; processed and printed in the U.S.A.'),(19,'Brain Logic T-Shirt','2XL','//image.spreadshirtmedia.com/image-server/v1/mp/products/T210A2MPA3176PT17X11Y8D1018359135FS3235/views/1,width=550,height=550,appearanceId=2,backgroundColor=F2F2F2,modelId=1147,crop=list/intelligence-is-the-ability-to-adapt-to-change-int-mens-t-shirt.jpg',19.99,1,'Brand: Hakentu || One of our faves! Top quality and best results with all print methods\nClassic round neckline || Very durable fabrics: 5.29 oz || Material: 100% cotton Imported product, printed & processed in the USA'),(20,'OnePice Carib Hoodie','XL','//image.spreadshirtmedia.com/image-server/v1/mp/products/T20A22MPA3631PT17X42Y28D1020384309FS5252/views/1,width=550,height=550,appearanceId=4,backgroundColor=F2F2F2,modelId=2516,crop=list/one-piece-straw-hat-pirates-flag-mens-premium-hoodie.jpg',39.99,2,'Brand: Cadino || 100% pre-shrunk cotton (heather gray color is 90% cotton/10% polyester, light heather gray is 98% cotton/2% polyester, heather black is 50% cotton/50% polyester) | Fabric Weight: 5.0 oz (mid-weight) Double-stitched seams at shoulder, sleeve, collar and waist || Special Note: Mineral Wash colors have a slight yellow tint and not one is the same due to the special dye process Imported || processed and printed in the U.S.A.'),(21,'Harry Poster Hoodie','S','//image.spreadshirtmedia.com/image-server/v1/mp/products/T405A2MPA4081PT17X48Y0D1033317598FS4856/views/1,width=550,height=550,appearanceId=2,backgroundColor=F2F2F2,modelId=2990,crop=list/harry-potter-ugly-christmas-chibi-design-womens-hoodie.jpg',37.99,2,'50% cotton / 50% polyester (Heather Gray is 53% polyester/ 47% cotton) || Fabric weight: 5.6oz (heavyweight)Dri-Power, moisture management properties Double-needle stitched hemmed sleeves ad bottom hem Seamless, 1x1 rib collar and body Imported || processed and printed in the U.S.A.'),(22,'Say Their Names T-Shirt','XL','//image.spreadshirtmedia.com/image-server/v1/mp/products/T812A2MPA3140PT17X6Y0D1021364436FS5306/views/1,width=550,height=550,appearanceId=2,backgroundColor=F2F2F2,modelId=115,crop=list/black-lives-matter-say-their-names-mens-premium-t-shirt.jpg',17.99,1,'Brand: Soloban || 100% pre-shrunk cotton (heather gray color is 90% cotton/10% polyester || light heather gray is 98% cotton/2% polyester, heather black is 50% cotton/50% polyester) || Fabric Weight: 5.0 oz (mid-weight) || Double-stitched seams at shoulder, sleeve, collar and waist || Special Note: Mineral Wash colors have a slight yellow tint and not one is the same due to the special dye process Imported || processed and printed in the U.S.A.\n\n'),(23,'Alex A Change The President Hoodie','XL','//image.spreadshirtmedia.com/image-server/v1/mp/products/T111A2MPA3629PT17X51Y47D1041407519FS2828/views/1,width=550,height=550,appearanceId=2,backgroundColor=F2F2F2,modelId=1460,crop=list/alexa-change-the-president-funny-anti-biden-46-mens-hoodie.jpg',39.99,2,'Brand: X-Demon || 100% pre-shrunk cotton (heather gray color is 90% cotton/10% polyester, light heather gray is 98% cotton/2% polyester, heather black is 50% cotton/50% polyester) || Fabric Weight: 5.0 oz (mid-weight) || Double-stitched seams at shoulder, sleeve, collar and waist || Special Note: Mineral Wash colors have a slight yellow tint and not one is the same due to the special dye process\nImported || processed and printed in the U.S.A.'),(24,'You Like Salt T-Shirt','XL','//image.spreadshirtmedia.com/image-server/v1/mp/products/T1172A54MPA3563PT17X7Y33D1036154577FS2940/views/1,width=550,height=550,appearanceId=54,backgroundColor=F2F2F2,modelId=2672,crop=list/you-like-scary-movies-too-womens-vintage-sport-t-shirt.jpg',19.99,1,'Brand: Sport Tek || 100% pre-shrunk cotton || PosiCharge moisture-wicking materials, roomy and highly breathable || Fabric weight: 3.8 oz (lightweight) || Material: 100% polyester interlock || Imported product, printed & processed in the USA\n'),(25,'Retro I Roll Hoodie','S','//image.spreadshirtmedia.com/image-server/v1/mp/products/T20A2MPA3631PT17X32Y4D1027263960FS2823/views/1,width=550,height=550,appearanceId=648,backgroundColor=F2F2F2,modelId=2516,crop=list/skater-this-is-how-i-roll-retro-skateboard-gift-mens-premium-hoodie.jpg',38.99,2,'Brand: Action Style || Unisex tailoring fits men rather tight and women more loosely (when in doubt, choose a size bigger or smaller)Light, super smooth fabrics 3.8 oz\nMaterial: 50% polyester, 25% cotton, 25% rayon || Imported, processed and printed in the U.S.A.\n'),(26,'Power God T-Shirt','XL','//image.spreadshirtmedia.com/image-server/v1/mp/products/T1112A54MPA3559PT17X0Y2D1000829857FS5875/views/1,width=550,height=550,appearanceId=54,backgroundColor=F2F2F2,modelId=3686,crop=list/this-shirt-is-illegal-in-51-countries-unisex-vintage-sport-t-shirt.jpg',19.99,1,'Brand: Nice Talk || 100% cotton (heather gray is 95% cotton/5% viscose. heather blue & charcoal gray are 80% cotton/20% polyester. heather burgundy is 60% cotton/40% polyester). | Fabric Weight: 4.42 oz || Fairly produced, certified and triple audited.Double stitched, reinforced seams at shoulder, sleeve, collar and waist\nProduct may run small, please check size chartsImported garment, processed and printed in the U.S.A.\n'),(27,'I\'m Not Regular Hoode','S','//image.spreadshirtmedia.com/image-server/v1/mp/products/T405A2MPA4081PT17X30Y19D1021763085FS2951/views/1,width=550,height=550,appearanceId=2,backgroundColor=F2F2F2,modelId=2990,crop=list/cool-mom-funny-mothers-gift-womens-hoodie.jpg',39.99,2,'Brand: Cadino || 100% pre-shrunk cotton (heather gray color is 90% cotton/10% polyester, light heather gray is 98% cotton/2% polyester, heather black is 50% cotton/50% polyester) | Fabric Weight: 5.0 oz (mid-weight) Double-stitched seams at shoulder, sleeve, collar and waist || Special Note: Mineral Wash colors have a slight yellow tint and not one is the same due to the special dye process Imported || processed and printed in the U.S.A.'),(28,'October Girl T-Shirt','XL','//image.spreadshirtmedia.com/image-server/v1/mp/products/T1260A2MPA3611PT17X33Y0D1023054180FS4716/views/1,width=550,height=550,appearanceId=164,backgroundColor=F2F2F2,modelId=2732,crop=list/im-an-october-girl-tshirt-womens-plus-size-t-shirt.jpg',18.99,1,'Brand: Hakentu || One of our faves! Top quality and best results with all print methods
\nClassic round neckline || Very durable fabrics: 5.29 oz || Material: 100% cotton Imported product, printed & processed in the USA'),(29,'Greetings Earthings T-Shirt','2XL','//image.spreadshirtmedia.com/image-server/v1/mp/products/T812A2MPA3140PT17X57Y30D1034012784FS4610/views/1,width=550,height=550,appearanceId=2,backgroundColor=F2F2F2,modelId=115,crop=list/looney-tunes-marvin-greetings-earthlings-mens-premium-t-shirt.jpg',19.99,1,'Brand: Avintex || This premium T-shirt is as close to perfect as can be. It
\'s optimized for all types of print and will quickly become your favorite T-shirt. Soft, comfortable and durable, this is a definite must-own. || Double stitched, reinforced seams at shoulder, sleeve, collar and waist || Optimized for beautiful brilliance across all printing methods Imported; processed and printed in the U.S.A.'),(30,'It\'s Drunk Camping Hoodie','XL','//image.spreadshirtmedia.com/image-server/v1/mp/products/T1007A309MPA3623PT17X36Y0D1022977086FS2613/views/1,width=550,height=550,appearanceId=309,backgroundColor=F2F2F2,modelId=1225,crop=list/if-im-drunk-it-s-my-camping-friends-fault-funny-unisex-two-tone-hoodie.jpg',39.99,2,'Brand: Titan Fall || Anti-fading color and print protection || Fabric weight: 3.8 oz (lightweight) || Material: 100% polyester interlock Imported product, printed & processed in the USA'),(31,'Sloth Running Team T-Shirt','2XL','//image.spreadshirtmedia.com/image-server/v1/mp/products/T347A2MPA2978PT17X11Y13D1021855671FS2402/views/1,width=550,height=550,appearanceId=4,backgroundColor=F2F2F2,modelId=2564,crop=list/vintage-sloth-running-team-we-ll-get-there-funny-womens-t-shirt.jpg',19.99,1,'
50% cotton / 50% polyester (Heather Gray is 53% polyester/ 47% cotton) || Fabric weight: 5.6oz (heavyweight)Dri-Power, moisture management properties Double-needle stitched hemmed sleeves ad bottom hem Seamless, 1x1 rib collar and body Imported || processed and printed in the U.S.A.'),(32,'I Came I Saw T-Shirt','S','//image.spreadshirtmedia.com/image-server/v1/mp/products/T210A2MPA3176PT17X0Y21D1009964639FS5585/views/1,width=550,height=550,appearanceId=4,backgroundColor=F2F2F2,modelId=1543,crop=list/funny-i-came-i-saw-i-made-it-awkward-mens-t-shirt.jpg',17.99,1,'Brand: Soloban || 100% pre-shrunk cotton (heather gray color is 90% cotton/10% polyester || light heather gray is 98% cotton/2% polyester, heather black is 50% cotton/50% polyester) || Fabric Weight: 5.0 oz (mid-weight) || Double-stitched seams at shoulder, sleeve, collar and waist || Special Note: Mineral Wash colors have a slight yellow tint and not one is the same due to the special dye process Imported || processed and printed in the U.S.A.
\n
\n'),(33,'I Want To Trees T-Shirt','XL','//image.spreadshirtmedia.com/image-server/v1/mp/products/T1194A648MPA2741PT17X34Y37D1028770075FS2539/views/1,width=550,height=550,appearanceId=648,backgroundColor=F2F2F2,modelId=1639,crop=list/arborist-tree-trimmer-tree-climber-arboriculturist-unisex-lightweight-terry-hoodie.jpg',39.99,2,'Brand: X-Demon || 100% pre-shrunk cotton (heather gray color is 90% cotton/10% polyester, light heather gray is 98% cotton/2% polyester, heather black is 50% cotton/50% polyester) || Fabric Weight: 5.0 oz (mid-weight) || Double-stitched seams at shoulder, sleeve, collar and waist || Special Note: Mineral Wash colors have a slight yellow tint and not one is the same due to the special dye process
\nImported || processed and printed in the U.S.A.'),(34,'Be Kind Full Color T-Shirt','XL','//image.spreadshirtmedia.com/image-server/v1/mp/products/T813A2MPA3132PT17X30Y32D1037495742FS2288/views/1,width=550,height=550,appearanceId=388,backgroundColor=F2F2F2,modelId=338,crop=list/autism-son-child-daughter-mom-be-kind-rainbow-womens-premium-t-shirt.jpg',19.99,1,'Brand: Sport Tek || 100% pre-shrunk cotton || PosiCharge moisture-wicking materials, roomy and highly breathable || Fabric weight: 3.8 oz (lightweight) || Material: 100% polyester interlock || Imported product, printed & processed in the USA
\n'),(35,'Never Understand Hoodie','S','//image.spreadshirtmedia.com/image-server/v1/mp/products/T444A2MPA4131PT17X54Y19D1025400894FS1905/views/1,width=550,height=550,appearanceId=2,backgroundColor=F2F2F2,modelId=1861,crop=list/chippewa-native-american-design-womens-premium-hoodie.jpg',38.99,2,'Brand: Action Style || Unisex tailoring fits men rather tight and women more loosely (when in doubt, choose a size bigger or smaller)Light, super smooth fabrics 3.8 oz
\nMaterial: 50% polyester, 25% cotton, 25% rayon || Imported, processed and printed in the U.S.A.
\n'),(36,'Ninja Assassin Hoodie','S','//image.spreadshirtmedia.com/image-server/v1/mp/products/T111A2MPA3629PT17X19Y42D1022973016FS5117/views/1,width=550,height=550,appearanceId=2,backgroundColor=F2F2F2,modelId=1460,crop=list/select-your-turtle-support-project-cowabunga-mens-hoodie.jpg',39.99,2,'Brand: Nice Talk || 100% cotton (heather gray is 95% cotton/5% viscose. heather blue & charcoal gray are 80% cotton/20% polyester. heather burgundy is 60% cotton/40% polyester). | Fabric Weight: 4.42 oz || Fairly produced, certified and triple audited.Double stitched, reinforced seams at shoulder, sleeve, collar and waist
\nProduct may run small, please check size chartsImported garment, processed and printed in the U.S.A.
\n'),(37,'Tom And Jerry T-Shirt','XL','//image.spreadshirtmedia.com/image-server/v1/mp/products/T812A317MPA3140PT17X44Y49D1034011244FS4311/views/1,width=550,height=550,appearanceId=2,backgroundColor=F2F2F2,modelId=115,crop=list/tom-and-jerry-catch-me-mens-premium-t-shirt.jpg',19.99,1,'Brand: Hakentu || One of our faves! Top quality and best results with all print methods
\nClassic round neckline || Very durable fabrics: 5.29 oz || Material: 100% cotton Imported product, printed & processed in the USA'),(38,'Ghost To Handle Hoodie','2XL','//image.spreadshirtmedia.com/image-server/v1/mp/products/T1007A309MPA3623PT17X67Y12D1012821210FS3690/views/1,width=550,height=550,appearanceId=309,backgroundColor=F2F2F2,modelId=1225,crop=list/napa-auto-parts-napa-auto-parts-tough-enough-unisex-two-tone-hoodie.jpg',37.99,2,'Brand: Avintex || This premium T-shirt is as close to perfect as can be. It
\'s optimized for all types of print and will quickly become your favorite T-shirt. Soft, comfortable and durable, this is a definite must-own. || Double stitched, reinforced seams at shoulder, sleeve, collar and waist || Optimized for beautiful brilliance across all printing methods Imported; processed and printed in the U.S.A.'),(39,'Women\'s March','XL','//image.spreadshirtmedia.com/image-server/v1/mp/products/T1352A1MPA3997PT17X10Y14D1010007347FS4659/views/1,width=550,height=550,appearanceId=1,backgroundColor=F2F2F2,modelId=3746,crop=list/womens-march-2017t-shirt-mens-organic-t-shirt.jpg',17.99,1,'
50% cotton / 50% polyester (Heather Gray is 53% polyester/ 47% cotton) || Fabric weight: 5.6oz (heavyweight)Dri-Power, moisture management properties Double-needle stitched hemmed sleeves ad bottom hem Seamless, 1x1 rib collar and body Imported || processed and printed in the U.S.A.'),(40,'UFO Pizza T-Shirt','S','//image.spreadshirtmedia.com/image-server/v1/mp/products/T813A231MPA3132PT17X15Y1D1021230845FS2599/views/1,width=550,height=550,appearanceId=804,backgroundColor=F2F2F2,modelId=338,crop=list/pizza-ufo-pick-up-womens-premium-t-shirt.jpg',19.99,1,'Brand: Soloban || 100% pre-shrunk cotton (heather gray color is 90% cotton/10% polyester || light heather gray is 98% cotton/2% polyester, heather black is 50% cotton/50% polyester) || Fabric Weight: 5.0 oz (mid-weight) || Double-stitched seams at shoulder, sleeve, collar and waist || Special Note: Mineral Wash colors have a slight yellow tint and not one is the same due to the special dye process Imported || processed and printed in the U.S.A.
\n
\n'),(41,'Grandma Know EverThing Hoodie','XL','//image.spreadshirtmedia.com/image-server/v1/mp/products/T111A2MPA3629PT17X74Y23D1038171622FS2193/views/1,width=550,height=550,appearanceId=2,backgroundColor=F2F2F2,modelId=1460,crop=list/grandma-knows-everything-mens-hoodie.jpg',39.99,2,'Brand: X-Demon || 100% pre-shrunk cotton (heather gray color is 90% cotton/10% polyester, light heather gray is 98% cotton/2% polyester, heather black is 50% cotton/50% polyester) || Fabric Weight: 5.0 oz (mid-weight) || Double-stitched seams at shoulder, sleeve, collar and waist || Special Note: Mineral Wash colors have a slight yellow tint and not one is the same due to the special dye process
\nImported || processed and printed in the U.S.A.'),(42,'Boo bees T-Shirt','S','//image.spreadshirtmedia.com/image-server/v1/mp/products/T347A1MPA2978PT17X11Y36D1025099820FS5423/views/1,width=550,height=550,appearanceId=1,backgroundColor=F2F2F2,modelId=2564,crop=list/boo-bees-couples-halloween-t-shirt-womens-t-shirt.jpg',19.99,1,'Brand: Sport Tek || 100% pre-shrunk cotton || PosiCharge moisture-wicking materials, roomy and highly breathable || Fabric weight: 3.8 oz (lightweight) || Material: 100% polyester interlock || Imported product, printed & processed in the USA
\n'),(43,'Pew Pew T-Shirt','S','//image.spreadshirtmedia.com/image-server/v1/mp/products/T1112A54MPA3559PT17X1Y22D1031320389FS3117/views/1,width=550,height=550,appearanceId=54,backgroundColor=F2F2F2,modelId=3686,crop=list/cat-pew-pew-madafakas-vintage-shirt-unisex-vintage-sport-t-shirt.jpg',18.99,1,'Brand: Action Style || Unisex tailoring fits men rather tight and women more loosely (when in doubt, choose a size bigger or smaller)Light, super smooth fabrics 3.8 oz
\nMaterial: 50% polyester, 25% cotton, 25% rayon || Imported, processed and printed in the U.S.A.
\n'),(44,'flower And Glass T-Shirt','S','//image.spreadshirtmedia.com/image-server/v1/mp/products/T1191A1MPA3535PT17X17Y12D1016533011FS4719/views/1,width=550,height=550,appearanceId=2,backgroundColor=F2F2F2,modelId=2696,crop=list/typography-global-nomad-spirit-womens-loose-fit-t-shirt.jpg',19.99,1,'Brand: Nice Talk || 100% cotton (heather gray is 95% cotton/5% viscose. heather blue & charcoal gray are 80% cotton/20% polyester. heather burgundy is 60% cotton/40% polyester). | Fabric Weight: 4.42 oz || Fairly produced, certified and triple audited.Double stitched, reinforced seams at shoulder, sleeve, collar and waist
\nProduct may run small, please check size chartsImported garment, processed and printed in the U.S.A.
\n');
