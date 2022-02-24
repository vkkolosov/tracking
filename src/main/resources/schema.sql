CREATE table container_prefix (

    id SERIAL PRIMARY KEY,
    prefix varchar(4),
    line varchar(40) REFERENCES url (line)

);

INSERT INTO container_prefix (prefix, line) VALUES
                                                ('APMU', 'Maersk'),
                                                ('FAAU', 'Maersk'),
                                                ('FRLU', 'Maersk'),
                                                ('KNLU', 'Maersk'),
                                                ('MAEU', 'Maersk'),
                                                ('MGBU', 'Maersk'),
                                                ('MHHU', 'Maersk'),
                                                ('MIEU', 'Maersk'),
                                                ('MMAU', 'Maersk'),
                                                ('MNBU', 'Maersk'),
                                                ('MRKU', 'Maersk'),
                                                ('MSFU', 'Maersk'),
                                                ('MSKU', 'Maersk'),
                                                ('MSWU', 'Maersk'),
                                                ('MVIU', 'Maersk'),
                                                ('MWCU', 'Maersk'),
                                                ('MWMU', 'Maersk'),
                                                ('MWSU', 'Maersk'),
                                                ('NDLU', 'Maersk'),
                                                ('OCLU', 'Maersk'),
                                                ('POCU', 'Maersk'),
                                                ('PONU', 'Maersk'),
                                                ('SAMU', 'Maersk'),
                                                ('SCMU', 'Maersk'),
                                                ('SEAU', 'Maersk'),
                                                ('TORU', 'Maersk');



CREATE table url (

    line varchar(40) PRIMARY KEY,
    line_full_name varchar (64),
    url varchar (128) NULL,
    post varchar (128) NULL
);