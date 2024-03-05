CREATE TABLE IF NOT EXISTS frete(
    id SERIAL PRIMARY KEY,
    cep_origem VARCHAR(9) NOT NULL,
    cep_destino VARCHAR(9) NOT NULL,
    altura FLOAT NOT NULL,
    largura FLOAT NOT NULL,
    comprimento FLOAT NOT NULL,
    peso FLOAT,
    cubagem FLOAT,
    valor FLOAT,
    indice TSVECTOR
);

CREATE OR REPLACE FUNCTION atualizar_tsvector() RETURNS TRIGGER AS $$
BEGIN
    NEW.indice := to_tsvector('portuguese',
                              COALESCE(NEW.cep_origem, '') || ' ' ||
                              COALESCE(NEW.cep_destino, '') || ' ' ||
                              COALESCE(NEW.altura::TEXT, '') || ' ' ||
                              COALESCE(NEW.largura::TEXT, '') || ' ' ||
                              COALESCE(NEW.comprimento::TEXT, '') || ' ' ||
                              COALESCE(NEW.peso::TEXT, '') || ' ' ||
                              COALESCE(NEW.cubagem::TEXT, '') || ' ' ||
                              COALESCE(NEW.valor::TEXT, ''));
RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER atualizar_tsvector_trigger BEFORE INSERT OR UPDATE
ON frete FOR EACH ROW EXECUTE FUNCTION atualizar_tsvector();

CREATE INDEX indice_gin ON frete USING GIN(indice);

