CREATE TABLE dds (
    id BIGSERIAL PRIMARY KEY,
    tema VARCHAR(150) NOT NULL,
    descricao TEXT NOT NULL,
    palestrante VARCHAR(150) NOT NULL,
    data_inicio TIMESTAMP NOT NULL,
    data_fim TIMESTAMP NOT NULL,
    status VARCHAR(20) NOT NULL
);

ALTER TABLE dds
ADD CONSTRAINT chk_dds_status
CHECK (status IN ('AGENDADO', 'CANCELADO', 'CONCLUIDO'));

ALTER TABLE dds
ADD CONSTRAINT chk_dds_datas
CHECK (data_fim > data_inicio);