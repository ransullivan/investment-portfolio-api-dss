TRUNCATE TABLE investment_transactions CASCADE;
TRUNCATE TABLE unit_prices CASCADE;

INSERT INTO unit_prices (id, nav_date, price) VALUES
(gen_random_uuid(), CURRENT_DATE - 6, 1400.0000),
(gen_random_uuid(), CURRENT_DATE - 5, 1420.0000),
(gen_random_uuid(), CURRENT_DATE - 4, 1450.0000),
(gen_random_uuid(), CURRENT_DATE - 3, 1475.0000),
(gen_random_uuid(), CURRENT_DATE - 2, 1480.0000),
(gen_random_uuid(), CURRENT_DATE - 1, 1490.0000),
(gen_random_uuid(), CURRENT_DATE, 1500.0000)
ON CONFLICT DO NOTHING;


INSERT INTO investment_transactions
(id, transaction_date, units)
VALUES
-- T-6 (pakai harga T-5)
(gen_random_uuid(), CURRENT_DATE - 6, 10.0000),
(gen_random_uuid(), CURRENT_DATE - 6, 15.5000),

-- T-4 (pakai harga T-3)
(gen_random_uuid(), CURRENT_DATE - 4, 20.0000),
(gen_random_uuid(), CURRENT_DATE - 4, 12.2500),

-- T-2 (pakai harga T-1)
(gen_random_uuid(), CURRENT_DATE - 2, 18.0000),
(gen_random_uuid(), CURRENT_DATE - 2, 25.1250)
ON CONFLICT DO NOTHING;