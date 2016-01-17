CREATE DOMAIN "School".one_letter
  AS text
        CHECK (
		VALUE ~ '^[A-Z]$'
		)
		;
