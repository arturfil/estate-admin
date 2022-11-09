CREATE TABLE IF NOT EXISTS estate (
    estate_id UUID PRIMARY KEY NOT NULL,
    address VARCHAR(100) NOT NULL UNIQUE,
    squared_feet INT NOT NULL,
    rented INT NOT NULL,
    type VARCHAR(10) NOT NULL
        CHECK (
            type = 'Appartment' OR
            type = 'House'      OR
            type = 'Townhouse'
        )
);