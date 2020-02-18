--Employees
INSERT INTO employees (badge, name, role)
    VALUES (1, 'Luiz', 'Intern');

INSERT INTO employees (badge, name, role)
    VALUES (2, 'Lipe', 'Intern');

INSERT INTO employees (badge, name, role)
    VALUES (3, 'Daniel', 'Intern');

INSERT INTO employees (badge, name, role)
    VALUES (4, 'Adilson', 'Badge');

INSERT INTO employees (badge, name, role)
    VALUES (5, 'Nelson', 'Badge');

INSERT INTO employees (badge, name, role)
    VALUES (6, 'Nicolas', 'Badge');

INSERT INTO employees (badge, name, role)
    VALUES (7, 'Jean', 'Contractor');

INSERT INTO employees (badge, name, role)
    VALUES (8, 'Wagner', 'Contractor');

INSERT INTO employees (badge, name, role)
    VALUES (9, 'Arthur', 'Contractor');


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
     VALUES (seq_event.nextval,
             'Dell Talk - Docker',
             'Talk about docker and kubernetes',
             10,
             'Ping Pong table',
             'Open',
             TO_DATE('2020/02/12 14:00:00', 'yyyy/mm/dd hh24:mi:ss'),
             TO_DATE('2020/12/12 16:00:00', 'yyyy/mm/dd hh24:mi:ss'),
             0);

INSERT INTO EVENTS (id,
                    name,
                    description,
                    capacity,
                    location,
                    event_target,
                    date,
                    final_date,
                    has_gift)
     VALUES (seq_event.nextval,
             'Dell Talk - Angular',
             'Angular framework tips',
             10,
             'Ping Pong table',
             'Open',
             TO_DATE('2020/02/12 14:00:00', 'yyyy/mm/dd hh24:mi:ss'),
             TO_DATE('2020/12/12 16:00:00', 'yyyy/mm/dd hh24:mi:ss'),
             0);

INSERT INTO EVENTS (id,
                    name,
                    description,
                    capacity,
                    location,
                    event_target,
                    date,
                    final_date,
                    has_gift)
     VALUES (seq_event.nextval,
             'Matrix Hackathon',
             'Interns hackathon (Role lock)',
             15,
             'Erico Verissimo',
             'Intern',
             TO_DATE('2020/02/12 14:00:00', 'yyyy/mm/dd hh24:mi:ss'),
             TO_DATE('2020/12/12 16:00:00', 'yyyy/mm/dd hh24:mi:ss'),
             1);

INSERT INTO EVENTS (id,
                    name,
                    description,
                    capacity,
                    location,
                    event_target,
                    date,
                    final_date,
                    has_gift)
    VALUES (seq_event.nextval,
           'Tech talk - Spring',
           'Talk about quality assurance (Date lock)',
           20,
           'Erico Verissimo',
           'Open',
           TO_DATE('2019/01/02 10:00:00', 'yyyy/mm/dd hh24:mi:ss'),
           TO_DATE('2019/01/02 13:00:00', 'yyyy/mm/dd hh24:mi:ss'),
           0);

--CheckIn
-- INSERT INTO EMPLOYEE_EVENTS (id,
--                              employee_badge,
--                              event_id,
--                              checkin_date)
--     VALUES (1,
--             1,
--             1,
--             TO_DATE('2020/01/12 10:02:23', 'yyyy/mm/dd hh24:mi:ss'));