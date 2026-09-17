-- Users
INSERT IGNORE INTO users (username, password, name, pet_type, email) VALUES
('themysteriousmara', 'MyMickey33', 'Mara', 'cat', 'maramay505@yahoo.com'),
('ldylandon', 'BotanyGRL626', 'Landon', NULL, 'crazyplantlady@hotmail.com'),
('fedallxn', 'tru$t&pixidust24!', 'Faith', 'cat', 'faithe.dall@gmail.com');

-- Species
INSERT IGNORE INTO species (common_name, scientific_name, watering_frequency, light_requirement, is_toxic, care_info, plant_image_url) VALUES
('Pothos', 'Epipremnum aureum', 7, 'Low to Medium', true, 'Water when the top inch of soil is dry. Tolerates low light but thrives in indirect light. Wipe leaves occasionally to remove dust.', 'https://example.com/pothos.jpg'),
('Monstera', 'Monstera deliciosa', 10, 'Medium to Bright Indirect', true, 'Water when the top 2 inches of soil are dry. Loves humidity and bright indirect light. Wipe leaves to keep them glossy.', 'https://example.com/monstera.jpg'),
('Spider Plant', 'Chlorophytum comosum', 7, 'Bright Indirect', false, 'Water when the top inch of soil feels dry. Thrives in bright indirect light. Great air purifier and very forgiving!', 'https://example.com/spider-plant.jpg'),
('Snake Plant', 'Sansevieria trifasciata', 14, 'Low to Bright Indirect', true, 'Water every 2 weeks in summer, monthly in winter. Extremely drought tolerant. One of the easiest plants to keep alive!', 'https://example.com/snake-plant.jpg'),
('Fiddle Leaf Fig', 'Ficus lyrata', 10, 'Bright Indirect', true, 'Water when the top inch of soil is dry. Needs consistent bright indirect light. Avoid moving it around — it hates change!', 'https://example.com/fiddle-leaf-fig.jpg'),
('Peace Lily', 'Spathiphyllum wallisii', 7, 'Low to Medium Indirect', true, 'Water when leaves start to droop slightly. Thrives in low light. A great indicator plant — it will tell you when it needs water!', 'https://example.com/peace-lily.jpg'),
('String of Pearls', 'Senecio rowleyanus', 14, 'Bright Indirect', true, 'Water sparingly — allow soil to dry completely between waterings. Hang out of reach of pets. Loves bright indirect light.', 'https://example.com/string-of-pearls.jpg'),
('Christmas Cactus', 'Schlumbergera bridgesii', 14, 'Bright Indirect', false, 'Water when the top inch of soil is dry, usually every 1-3 weeks. Reduce watering during blooming period. Pet safe!', 'https://example.com/christmas-cactus.jpg'),
('Alocasia', 'Alocasia amazonica', 7, 'Medium to Bright Indirect', true, 'Keep soil consistently moist but not soggy. Loves humidity. Reduce watering in winter when plant goes dormant.', 'https://example.com/alocasia.jpg'),
('ZZ Plant', 'Zamioculcas zamiifolia', 14, 'Low to Bright Indirect', true, 'Water every 2-3 weeks in summer, monthly in winter. Extremely drought tolerant. Keep away from pets — toxic if ingested.', 'https://example.com/zz-plant.jpg'),
('Caladium', 'Caladium bicolor', 4, 'Bright Indirect', true, 'Keep soil evenly moist during growing season. Loves humidity and bright indirect light. Reduce watering when dormant in winter.', 'https://example.com/caladium.jpg'),
('Jade Plant', 'Crassula ovata', 14, 'Bright Direct', true, 'Allow soil to dry completely between waterings. Needs bright light with some direct sun. Very drought tolerant — less is more!', 'https://example.com/jade-plant.jpg');

-- Mara's Plants
INSERT IGNORE INTO plants (nickname, user_id, species_id, created_at) VALUES
('Arachnia', 2, 3, NOW()),
('Princess P.', 2, 7, NOW()),
('Holly', 2, 8, NOW()),
('Eunice', 2, 1, NOW());

-- Faith's Plants
INSERT IGNORE INTO plants (nickname, user_id, species_id, created_at) VALUES
('Majesty', 3, 2, NOW()),
('Ares', 3, 4, NOW()),
('Aphrodite', 3, 7, NOW()),
('Tyche', 3, 12, NOW()),
('Hypnos', 3, 10, NOW()),
('Plutus', 3, 11, NOW());

-- Landon's Plants
INSERT IGNORE INTO plants (nickname, user_id, species_id, created_at) VALUES
('Figitus', 1, 5, NOW()),
('Lillian', 1, 6, NOW()),
('Alicia', 1, 9, NOW()),
('Cally', 1, 11, NOW()),
('Zishop', 1, 10, NOW()),
('Gal', 1, 3, NOW()),
('Ms. Pearl', 1, 7, NOW()),
('The Queen', 1, 2, NOW()),
('Sepentina', 1, 4, NOW());