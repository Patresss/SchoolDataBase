CREATE DOMAIN "School".one_digit
  AS text
        CHECK (
		VALUE ~ '^[0-9]$'
		)
		;
