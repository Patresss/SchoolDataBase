CREATE DOMAIN "School".start_upper
  AS text
        CHECK (
		VALUE ~ '^[A-ZĄĆĘŁŃÓŚŹŻ]'
		);
