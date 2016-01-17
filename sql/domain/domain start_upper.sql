CREATE DOMAIN start_upper
  AS text
        CHECK (
		VALUE ~ '^[A-ZĄĆĘŁŃÓŚŹŻ]'
		);
