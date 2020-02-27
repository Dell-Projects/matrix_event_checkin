--Employees
INSERT INTO employees (badge, name, role)
    VALUES
    (1, 'Luiz', 'Intern'),
    (2, 'Daniel', 'Intern'),
    (3, 'Lipe', 'Intern'),
    (4, 'Adilson', 'Intern'),
    (5, 'Jean', 'Badge'),
    (6, 'Arthur', 'Badge'),
    (7, 'Wagner', 'Badge'),
    (8, 'Richard', 'Contractor'),
    (9, 'Gabriel', 'Contractor'),
    (10, 'Felipe', 'Contractor'),
    (11, 'Renata', 'Intern'),
    (12, 'Cleyson', 'Intern'),
    (13, 'Matheus', 'Intern'),
    (14, 'Mangan', 'Badge'),
    (15, 'Laura', 'Badge'),
    (16, 'Nelson', 'Badge');


--Events
INSERT INTO EVENTS (id,
                    name,
                    description,
                    capacity,
                    location,
                    event_target,
                    date,
                    final_date,
                    has_gift)
     VALUES
     (
        seq_event.nextval,
        'Dell Talk - Docker',
        'Talk about docker and kubernetes',
        10,
        'Ping Pong table',
        'Open',
        TO_DATE('2020/02/12 14:00:00', 'yyyy/mm/dd hh24:mi:ss'),
        TO_DATE('2020/12/12 16:00:00', 'yyyy/mm/dd hh24:mi:ss'),
        0
     ),
     (
        seq_event.nextval,
        'Dell Talk - Angular',
        'Angular framework tips (Capacity lock)',
        2,
        'Ping Pong table',
        'Open',
        TO_DATE('2020/02/12 14:00:00', 'yyyy/mm/dd hh24:mi:ss'),
        TO_DATE('2020/12/12 16:00:00', 'yyyy/mm/dd hh24:mi:ss'),
        0
     ),
     (
        seq_event.nextval,
        'Matrix Hackathon',
        'Interns hackathon (Role lock)',
        15,
        'Erico Verissimo',
        'Intern',
        TO_DATE('2020/02/12 14:00:00', 'yyyy/mm/dd hh24:mi:ss'),
        TO_DATE('2020/12/12 16:00:00', 'yyyy/mm/dd hh24:mi:ss'),
        1
     ),
     (
        seq_event.nextval,
        'Tech talk - Spring',
        'Talk about quality assurance (Date lock)',
        20,
        'Erico Verissimo',
        'Open',
        TO_DATE('2019/01/02 10:00:00', 'yyyy/mm/dd hh24:mi:ss'),
        TO_DATE('2019/01/02 13:00:00', 'yyyy/mm/dd hh24:mi:ss'),
        0
     );


--CheckIn
-- INSERT INTO EMPLOYEE_EVENTS (id,
--                              employee_badge,
--                              event_id,
--                              checkin_date)
--     VALUES (1,
--             1,
--             1,
--             TO_DATE('2020/01/12 10:02:23', 'yyyy/mm/dd hh24:mi:ss'));