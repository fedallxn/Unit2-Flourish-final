-- Users
INSERT IGNORE INTO users (username, password, name, pet_type, created_at) VALUES
('themysteriousmara', 'MyMickey33', 'Mara', 'cat', NOW()),
('ldylandon', 'BotanyGRL626', 'Landon', NULL, NOW()),
('fedallxn', 'tru$t&pixidust24!', 'Faith', 'cat', NOW());

-- Species
INSERT IGNORE INTO species (common_name, scientific_name, watering_frequency, light_requirement, is_toxic, care_info, plant_image_url) VALUES
('Pothos', 'Epipremnum aureum', 7, 'Low to Medium', true, 'Water when the top inch of soil is dry. Tolerates low light but thrives in indirect light. Wipe leaves occasionally to remove dust.', 'http://localhost:8080/pothos.jpg'),
('Monstera', 'Monstera deliciosa', 10, 'Medium to Bright Indirect', true, 'Water when the top 2 inches of soil are dry. Loves humidity and bright indirect light. Wipe leaves to keep them glossy.', 'http://localhost:8080/monstera.jpg'),
('Spider Plant', 'Chlorophytum comosum', 7, 'Bright Indirect', false, 'Water when the top inch of soil feels dry. Thrives in bright indirect light. Great air purifier and very forgiving!', 'http://localhost:8080/spider-plant.jpg'),
('Snake Plant', 'Sansevieria trifasciata', 14, 'Low to Bright Indirect', true, 'Water every 2 weeks in summer, monthly in winter. Extremely drought tolerant. One of the easiest plants to keep alive!', 'http://localhost:8080/snake-plant.jpg'),
('Fiddle Leaf Fig', 'Ficus lyrata', 10, 'Bright Indirect', true, 'Water when the top inch of soil is dry. Needs consistent bright indirect light. Avoid moving it around — it hates change!', 'http://localhost:8080/fiddle-leaf-fig.jpg'),
('Peace Lily', 'Spathiphyllum wallisii', 7, 'Low to Medium Indirect', true, 'Water when leaves start to droop slightly. Thrives in low light. A great indicator plant — it will tell you when it needs water!', 'http://localhost:8080/peace-lily.jpg'),
('String of Pearls', 'Senecio rowleyanus', 14, 'Bright Indirect', true, 'Water sparingly — allow soil to dry completely between waterings. Hang out of reach of pets. Loves bright indirect light.', 'http://localhost:8080/string-of-pearls.jpg'),
('Christmas Cactus', 'Schlumbergera bridgesii', 14, 'Bright Indirect', false, 'Water when the top inch of soil is dry, usually every 1-3 weeks. Reduce watering during blooming period. Pet safe!', 'http://localhost:8080/christmas-cactus.jpg'),
('Alocasia', 'Alocasia amazonica', 7, 'Medium to Bright Indirect', true, 'Keep soil consistently moist but not soggy. Loves humidity. Reduce watering in winter when plant goes dormant.', 'http://localhost:8080/alocasia.jpg'),
('ZZ Plant', 'Zamioculcas zamiifolia', 14, 'Low to Bright Indirect', true, 'Water every 2-3 weeks in summer, monthly in winter. Extremely drought tolerant. Keep away from pets — toxic if ingested.', 'http://localhost:8080/zz-plant.jpg'),
('Caladium', 'Caladium bicolor', 4, 'Bright Indirect', true, 'Keep soil evenly moist during growing season. Loves humidity and bright indirect light. Reduce watering when dormant in winter.', 'http://localhost:8080/caladium.jpg'),
('Jade Plant', 'Crassula ovata', 14, 'Bright Direct', true, 'Allow soil to dry completely between waterings. Needs bright light with some direct sun. Very drought tolerant — less is more!', 'http://localhost:8080/jade-plant.jpg');

-- Mara's Plants
INSERT IGNORE INTO plants (nickname, species_name, plant_image_url, user_user_id, species_species_id, created_at) VALUES
('Arachnia', 'Spider Plant', 'http://localhost:8080/spider-plant.jpg', 2, 3, NOW()),
('Princess P.', 'String of Pearls', 'http://localhost:8080/string-of-pearls.jpg', 2, 7, NOW()),
('Holly', 'Christmas Cactus', 'http://localhost:8080/christmas-cactus.jpg', 2, 8, NOW()),
('Eunice', 'Pothos', 'http://localhost:8080/pothos.jpg', 2, 1, NOW());

-- Faith's Plants
INSERT IGNORE INTO plants (nickname, species_name, plant_image_url, user_user_id, species_species_id, created_at) VALUES
('Majesty', 'Monstera', 'http://localhost:8080/monstera.jpg', 3, 2, NOW()),
('Ares', 'Snake Plant', 'http://localhost:8080/snake-plant.jpg', 3, 4, NOW()),
('Aphrodite', 'String of Pearls', 'http://localhost:8080/string-of-pearls.jpg', 3, 7, NOW()),
('Tyche', 'Jade Plant', 'http://localhost:8080/jade-plant.jpg', 3, 12, NOW()),
('Hypnos', 'ZZ Plant', 'http://localhost:8080/zz-plant.jpg', 3, 10, NOW()),
('Plutus', 'Caladium', 'http://localhost:8080/caladium.jpg', 3, 11, NOW());

-- Landon's Plants
INSERT IGNORE INTO plants (nickname, species_name, plant_image_url, user_user_id, species_species_id, created_at) VALUES
('Figitus', 'Fiddle Leaf Fig', 'http://localhost:8080/fiddle-leaf-fig.jpg', 1, 5, NOW()),
('Lillian', 'Peace Lily', 'http://localhost:8080/peace-lily.jpg', 1, 6, NOW()),
('Alicia', 'Alocasia', 'http://localhost:8080/alocasia.jpg', 1, 9, NOW()),
('Cally', 'Caladium', 'http://localhost:8080/caladium.jpg', 1, 11, NOW()),
('Zishop', 'ZZ Plant', 'http://localhost:8080/zz-plant.jpg', 1, 10, NOW()),
('Gal', 'Spider Plant', 'http://localhost:8080/spider-plant.jpg', 1, 3, NOW()),
('Ms. Pearl', 'String of Pearls', 'http://localhost:8080/string-of-pearls.jpg', 1, 7, NOW()),
('The Queen', 'Monstera', 'http://localhost:8080/monstera.jpg', 1, 2, NOW()),
('Sepentina', 'Snake Plant', 'http://localhost:8080/snake-plant.jpg', 1, 4, NOW());