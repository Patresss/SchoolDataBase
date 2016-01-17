CREATE DOMAIN one_digit
  AS text
        CHECK (
		VALUE ~ '^[0-9]$'
		)
		;
