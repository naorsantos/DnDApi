create table magia (
        id integer not null,
        nivel integer,
        ritual boolean,
        magia_classe varchar(50) not null,
        alcance varchar(255),
        componente_magia varchar(255),
        descricao TEXT,
        duracao varchar(255),
        nome varchar(255),
        tempo_conjuracao varchar(255),
        escola_de_magia enum ('ABJURACAO','ADIVINHACAO','CONJURACAO','ENCANTAMENTO','EVOCACAO','ILUSAO','NECROMANCIA','TRANSMUTACAO') not null,
        primary key (id)
    );