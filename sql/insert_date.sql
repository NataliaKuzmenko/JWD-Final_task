/*users*/
INSERT INTO users (password,email,first_name,last_name,role_id)
VALUES ('ec2014daa771869ad5dc6c3de318468e52d0bc6ab0451b89ccda2d696f826fe8315559b8ded96ccabb79db0a0a2232b9d63171c0eb6ea953823d28efdabd53c1','nat.s.kuzmenko@gmail.com', 'Наталья','Кузьменко','ADMIN');
INSERT INTO users (password,email,first_name,last_name,role_id)
VALUES ('ec2014daa771869ad5dc6c3de318468e52d0bc6ab0451b89ccda2d696f826fe8315559b8ded96ccabb79db0a0a2232b9d63171c0eb6ea953823d28efdabd53c1', 'makushka.nataha@gmail.com', 'Петр','Петрович','LECTURER');
INSERT INTO users (password,email,first_name,last_name)
VALUES ('ec2014daa771869ad5dc6c3de318468e52d0bc6ab0451b89ccda2d696f826fe8315559b8ded96ccabb79db0a0a2232b9d63171c0eb6ea953823d28efdabd53c1', 'email1@mail.ru', 'Семен','Семенов');
INSERT INTO users (password,email,first_name,last_name)
VALUES ('ec2014daa771869ad5dc6c3de318468e52d0bc6ab0451b89ccda2d696f826fe8315559b8ded96ccabb79db0a0a2232b9d63171c0eb6ea953823d28efdabd53c1', 'email2@mail.ru', 'Сергей','Сергеев');
INSERT INTO users (password,email,first_name,last_name)
VALUES ('ec2014daa771869ad5dc6c3de318468e52d0bc6ab0451b89ccda2d696f826fe8315559b8ded96ccabb79db0a0a2232b9d63171c0eb6ea953823d28efdabd53c1', 'email3@mail.ru', 'Александр','Александров');
INSERT INTO users (password,email,first_name,last_name)
VALUES ('ec2014daa771869ad5dc6c3de318468e52d0bc6ab0451b89ccda2d696f826fe8315559b8ded96ccabb79db0a0a2232b9d63171c0eb6ea953823d28efdabd53c1', 'email4@mail.ru', 'Игорь','Игорев');
INSERT INTO users (password,email,first_name,last_name)
VALUES ('ec2014daa771869ad5dc6c3de318468e52d0bc6ab0451b89ccda2d696f826fe8315559b8ded96ccabb79db0a0a2232b9d63171c0eb6ea953823d28efdabd53c1', 'email5@mail.ru', 'Геннадий','Геннадьев');
INSERT INTO users (password,email,first_name,last_name)
VALUES ('ec2014daa771869ad5dc6c3de318468e52d0bc6ab0451b89ccda2d696f826fe8315559b8ded96ccabb79db0a0a2232b9d63171c0eb6ea953823d28efdabd53c1', 'email6@mail.ru', 'Василиса','Васильевна');
INSERT INTO users (password,email,first_name,last_name)
VALUES ('ec2014daa771869ad5dc6c3de318468e52d0bc6ab0451b89ccda2d696f826fe8315559b8ded96ccabb79db0a0a2232b9d63171c0eb6ea953823d28efdabd53c1', 'email7@mail.ru', 'Мария','Марьянова');
INSERT INTO users (password,email,first_name,last_name)
VALUES ('ec2014daa771869ad5dc6c3de318468e52d0bc6ab0451b89ccda2d696f826fe8315559b8ded96ccabb79db0a0a2232b9d63171c0eb6ea953823d28efdabd53c1', 'email8@mail.ru', 'Ольга','Орлова');
INSERT INTO users (password,email,first_name,last_name)
VALUES ('ec2014daa771869ad5dc6c3de318468e52d0bc6ab0451b89ccda2d696f826fe8315559b8ded96ccabb79db0a0a2232b9d63171c0eb6ea953823d28efdabd53c1', 'email9@mail.ru', 'Анна','Каренина');
INSERT INTO users (password,email,first_name,last_name)
VALUES ('ec2014daa771869ad5dc6c3de318468e52d0bc6ab0451b89ccda2d696f826fe8315559b8ded96ccabb79db0a0a2232b9d63171c0eb6ea953823d28efdabd53c1', 'email10@mail.ru', 'Анастасия','Сидорова');

/*courses*/
INSERT INTO courses (course_title, description, materials_path)
VALUES ('Общий курс английского языка',
        'ОБЩИЙ КУРС АНГЛИЙСКОГО ЯЗЫКА – иностранный язык «для жизни». Программа подходит для любого уровня подготовки, от Starter (A1) до Proficiency (C2). Направлена на практическое овладение английским языком в комплексе и преодоление психологического барьера при общении. Общий курс направлен на формирование и совершенствование всех языковых и коммуникативных навыков того уровня сложности, на котором вы занимаетесь. Мы проводим занятия по учебным материалам, разработанным совместно с BBC Worldwide и BBC Learning English. Обучаясь по материалам программ BBC, вы будете слышать живой английский язык и знать все последние новости. Темы курса расширяют кругозор, разные варианты произношения в видео- и аудиоматериалах помогают «настроить ухо». Вы научитесь воспринимать спикеров  на слух – носителей языка и тех, для кого английский не родной. Особое внимание уделяется освоению разговорных клише. Системный подход к обучению чтению и письму совершенствует навыки критического мышления. Следить за прогрессом и определять зоны развития вам помогут проверочные и тренировочные тесты. На уровнях Starter (A1) – Upper Intermediate (B2) мы занимаемся по интерактивному авторскому онлайн-пособию Compass New. Мы создали его для работы над грамотностью и лексическим разнообразием речи. На уровне Proficiency (C2) рассматриваем презентации выдающихся в своей области людей на TED Talk, всемирно известной платформе по обмену интересными идеями. Материалы на общую и бизнес-тематику используем как модели для обучения, источник аутентичного материала. Обсуждаем интересные факты и идеи.',
        'materials.pdf');

INSERT INTO courses (course_title, description, materials_path)
VALUES ('Английский язык по выходным',
        'КУРС АНГЛИЙСКОГО ЯЗЫКА ПО ВЫХОДНЫМ– иностранный язык «для жизни» по выходным дням. Программа направлена на практическое овладение английским языком в комплексе и преодоление психологического барьера при общении. Общий курс направлен на формирование и совершенствование всех языковых и коммуникативных навыков в соответствии с уровнем сложности, на котором вы занимаетесь. Для обучения мы используем современный учебный комплекс, разработанный совместно с BBC Worldwide и BBC Learning English. Занимаясь по программам ВВС, вы будете слышать живой современный английский язык и знать все последние новости. Предлагаемые темы расширяют кругозор, различные варианты произношения в видео- и аудиоматериалах помогут «настроить ухо» и научиться воспринимать разных спикеров – носителей языка и тех, для кого английский не родной. Особое внимание уделяется освоению разговорных клише. Системный подход к обучению чтению и письму совершенствует навыки критического мышления. Студенты выполняют проверочные и тренировочные тесты, что позволяет следить за своим прогрессом и определять зоны развития. На уровнях до Upper Intermediate (B2) предлагается интерактивное авторское онлайн-пособие Compass New, разработанное нашей командой, для работы над грамотностью и лексическим разнообразием речи. Занятия проходят очно по субботам. Для самостоятельной дистанционной работы мы предлагаем учебные тексты и грамматические правила, комплекс тренировочных и коммуникативных упражнений, аутентичные аудио и видеоресурсы. Очные занятия английским с преподавателем помогут «всегда быть в тонусе». Вы сможете общаться с преподавателем и коллегами через программу, удалено. Задания проверяются автоматически. Прогресс в обучении будет отражаться при помощи разнообразных графиков. Благодаря интеграции очных и дистанционных заданий Weekend+ помогает максимально эффективно использовать рабочее время, сокращает расстояние между преподавателем и студентом.
        ',
        'materials.pdf');

INSERT INTO courses (course_title, description, materials_path)
VALUES ('Английский язык для начинающих с нуля',
        'КУРС АНГЛИЙСКОГО ЯЗЫКА ДЛЯ НАЧИНАЮЩИХ – это иностранный язык для жизни, который поможет научиться общаться в ситуациях повседневного общения, преодолеть психологический барьер при общении и полюбить иностранный. Общий курс направлен на формирование и совершенствование всех языковых и коммуникативных навыков в соответствии с уровнем сложности, на котором вы занимаетесь. В рамках программы используется современный учебный комплекс, разработанный совместно с BBC Worldwide и BBC Learning English. В основу учебной программы легли материалы различных программ BBC, что позволяет вам быть в курсе новостей и получить доступ к «живому» актуальному языку. Предлагаемые темы расширяют кругозор, различные варианты произношения в видео и аудио материалах помогут «настроить ухо» и научиться воспринимать разных спикеров – как носителей языка, так и тех, для кого английский не является родным. Особое внимание уделяется освоению разговорных клише. Системный подход к обучению чтению и письму совершенствует навыки критического мышления. В течение курса студенты выполняют проверочные и тренировочные тесты, что позволяет следить за своим прогрессом и определять зоны развития. Также на уровне Starter (A1) предлагается интерактивное авторское онлайн пособие Compass New, разработанное нашей командой, для работы над грамотностью и лексическим разнообразием речи.',
        'materials.pdf');

INSERT INTO courses (course_title, description, materials_path)
VALUES ('Экспресс-курс английского языка',
        'ЭКСПРЕСС-КУРС АНГЛИЙСКОГО ЯЗЫКА – это общий курс английского «для жизни» в интенсивном формате. Программа доступна на любом уровне подготовки от Starter («с нуля») до Proficiency (C2). Направлена на практическое овладение английским языком в комплексе и преодоление психологического барьера при общении. Экспресс-курс направлен на формирование и совершенствование всех языковых и коммуникативных навыков в соответствии с уровнем сложности, на котором вы занимаетесь. Мы проводим занятия  по учебным материалам, разработанным совместно с BBC Worldwide и BBC Learning English. Занимаясь по программам ВВС, вы будете слышать живой современный английский язык и знать все последние новости. Изучаемые на курсах темы расширяют кругозор. Разные варианты произношения в видео- и аудиоматериалах «настроят ухо» и научат воспринимать на слух речь носителей языка и тех, для кого английский не родной. Особое внимание уделяется освоению разговорных клише. Системный подход к обучению чтению и письму совершенствует навыки критического мышления. Следить за своим прогрессом и определять зоны развития вам помогут проверочные и тренировочные тесты. На уровнях Starter (A1) – Upper Intermediate (B2) предлагается интерактивное авторское онлайн-пособие Compass New, разработанное нашей командой для работы над грамотностью и лексическим разнообразием речи. На уровне Proficiency (C2) мы прорабатываем самые успешные презентации выдающихся в своей области людей на TED Talk, всемирно известной платформы по обмену интересными идеями. Мы используем презентации на общую и бизнес-тематику как модели для обучения. Мы обсуждаем интересные факты и идеи из этих познавательных аутентичных материалов.
        ',
        'materials.pdf');

INSERT INTO courses (course_title, description, materials_path)
VALUES ('Бизнес-курс английского языка',
        'КУРС ДЕЛОВОГО АНГЛИЙСКОГО ЯЗЫКА – программа комплексного изучения английского языка на разных уровнях сложности, от Elementary (A2) до Advanced (C1), для использования в ситуациях делового общения.  На каждом уровне обучения студенты проходят 12–15 тем. Урок строится вокруг реальных коммуникативных ситуаций, связанных с работой и бизнесом. Рассматривается взаимодействие с зарубежными коллегами и деловыми партнерами по телефону, электронной почте, а также в рамках живого общения через деловые и неформальные обсуждения, совещания, встречи. Большой упор делается на развитие навыков делового и ежедневного общения. Студенты учатся вести переговоры, выступать на собраниях, представлять свой продукт, устанавливать деловые отношения, обмениваться контактами и  предоставлять финансовую информацию. А также извиняться, хвалить и благодарить, вежливо заканчивать разговор и корректно задавать вопросы. Мы занимаемся по учебному пособию издательства Oxford. В нем много аудиозаписей с примерами общения из офисной жизни, бизнес-встреч, видеоинтервью с ведущими экспертами, аналитиками и владельцами бизнеса.  Мы отобрали  языковой материал по принципу частотности и полезности. Обсуждения и проигрывание ситуаций реального общения формируют беглую речь и уверенное использование языка. На занятиях студенты также изучают кросс-культурные особенности взаимодействия людей из разных стран.',
        'materials.pdf');

INSERT INTO courses (course_title, description, materials_path)
VALUES ('Подготовиться к экзамену TOEFL',
        'Мы предлагаем комплексную программу подготовки ко всем аспектам международного экзамена TOEFL iBT® (Internet-based Version of the Test of English as a Foreign Language). Мы также помогаем своим клиентам при регистрации на экзамен. Для подготовки к экзамену TOEFL iBT® используются специализированные учебные материалы, как аутентичные, так и разработанные нашими методистами. На каждом занятии уделяется внимание развитию всех видов речевой деятельности, необходимых для успешной сдачи теста: чтения, восприятия речи на слух, устной речи и письма. Учащихся знакомят со спецификой экзамена, моделируя ситуации, максимально приближенные к условиям сдачи. Одновременно с совершенствованием навыков и умений, учащиеся усваивают материал, необходимый для свободного понимания лекций и семинаров, для общения на занятиях в зарубежных университетах и повседневной жизни. Для обучения на курсе подготовки к экзамену TOEFL iBT® необходимо владеть английским языком на высоком уровне (Upper Intermediate и выше). Определить свой уровень знаний можно на бесплатном предварительном тестировании. Подготовиться к TOEFL iBT® можно за 4-6 месяцев в зависимости от интенсивности графика занятий. Программа разбита на семестры по 8 недель в каждом.',
        'materials.pdf');
INSERT INTO courses (course_title,description)
VALUES ('Подготовиться к экзамену IELTS','IELTS (International English Language Testing System) — международная система оценки знания английского языка. Позволяет определить уровень и навыки владения английским языком у людей, для которых он не является родным. Мы предлагаем комплексную программу подготовки ко всем аспектам экзамена IELTS . Для того чтобы заниматься по этой программе необходимо владеть английским языком на продвинутом уровне - Upper Intermediate и выше. Определить свой уровень знаний можно на бесплатном предварительном тестировании. Занятия проходят 2 раза в неделю по 2 академических часа в течение 4-х месяцев.');

/*course_run*/
INSERT INTO course_run (course_id,start_course,end_course,lecturer_id,format)
VALUES (1,'2021-09-01', '2022-05-31',2,'OFFLINE');
INSERT INTO course_run (course_id,start_course,end_course,lecturer_id,format)
VALUES (2,'2021-06-01', '2021-08-31',2,'OFFLINE');
INSERT INTO course_run (course_id,start_course,end_course,lecturer_id,format)
VALUES (3,'2021-06-01', '2021-08-31',2,'OFFLINE');
INSERT INTO course_run (course_id,start_course,end_course,lecturer_id,format)
VALUES (4,'2021-06-01', '2021-08-31',2,'OFFLINE');
INSERT INTO course_run (course_id,start_course,end_course,lecturer_id,format)
VALUES (5,'2021-09-01', '2022-05-31',2,'OFFLINE');
INSERT INTO course_run (course_id,start_course,end_course,lecturer_id,format)
VALUES (6,'2021-06-01', '2021-08-31',2,'OFFLINE');

/*lists_students*/
INSERT INTO lists_students (user_id, course_run_id,status_student_id)
VALUES ('3','1','TRAINING_IN_PROGRESS');
INSERT INTO lists_students (user_id, course_run_id,status_student_id)
VALUES ('4','1','TRAINING_IN_PROGRESS');
INSERT INTO lists_students (user_id, course_run_id,status_student_id)
VALUES ('5','1','TRAINING_IN_PROGRESS');
INSERT INTO lists_students (user_id, course_run_id,status_student_id)
VALUES ('6','1','TRAINING_IN_PROGRESS');
INSERT INTO lists_students (user_id, course_run_id,status_student_id)
VALUES ('7','1','TRAINING_IN_PROGRESS');

INSERT INTO lists_students (user_id, course_run_id,status_student_id)
VALUES ('8','2','TRAINING_IN_PROGRESS');
INSERT INTO lists_students (user_id, course_run_id,status_student_id)
VALUES ('9','2','TRAINING_IN_PROGRESS');
INSERT INTO lists_students (user_id, course_run_id,status_student_id)
VALUES ('10','2','TRAINING_IN_PROGRESS');
INSERT INTO lists_students (user_id, course_run_id,status_student_id)
VALUES ('11','2','TRAINING_IN_PROGRESS');
INSERT INTO lists_students (user_id, course_run_id,status_student_id)
VALUES ('12','2','TRAINING_IN_PROGRESS');

INSERT INTO lists_students (user_id, course_run_id,status_student_id)
VALUES ('3','3','TRAINING_IN_PROGRESS');
INSERT INTO lists_students (user_id, course_run_id,status_student_id)
VALUES ('4','3','TRAINING_IN_PROGRESS');
INSERT INTO lists_students (user_id, course_run_id,status_student_id)
VALUES ('5','3','TRAINING_IN_PROGRESS');
INSERT INTO lists_students (user_id, course_run_id,status_student_id)
VALUES ('6','3','TRAINING_IN_PROGRESS');
INSERT INTO lists_students (user_id, course_run_id,status_student_id)
VALUES ('7','3','TRAINING_IN_PROGRESS');

INSERT INTO lists_students (user_id, course_run_id,status_student_id)
VALUES ('8','4','TRAINING_IN_PROGRESS');
INSERT INTO lists_students (user_id, course_run_id,status_student_id)
VALUES ('9','4','TRAINING_IN_PROGRESS');
INSERT INTO lists_students (user_id, course_run_id,status_student_id)
VALUES ('10','4','TRAINING_IN_PROGRESS');
INSERT INTO lists_students (user_id, course_run_id,status_student_id)
VALUES ('11','4','TRAINING_IN_PROGRESS');
INSERT INTO lists_students (user_id, course_run_id,status_student_id)
VALUES ('12','4','TRAINING_IN_PROGRESS');

INSERT INTO lists_students (user_id, course_run_id,status_student_id)
VALUES ('3','5','TRAINING_IN_PROGRESS');
INSERT INTO lists_students (user_id, course_run_id,status_student_id)
VALUES ('4','5','TRAINING_IN_PROGRESS');
INSERT INTO lists_students (user_id, course_run_id,status_student_id)
VALUES ('5','5','TRAINING_IN_PROGRESS');
INSERT INTO lists_students (user_id, course_run_id,status_student_id)
VALUES ('6','5','TRAINING_IN_PROGRESS');
INSERT INTO lists_students (user_id, course_run_id,status_student_id)
VALUES ('7','5','TRAINING_IN_PROGRESS');

INSERT INTO lists_students (user_id, course_run_id,status_student_id)
VALUES ('8','6','TRAINING_IN_PROGRESS');
INSERT INTO lists_students (user_id, course_run_id,status_student_id)
VALUES ('9','6','TRAINING_IN_PROGRESS');
INSERT INTO lists_students (user_id, course_run_id,status_student_id)
VALUES ('10','6','TRAINING_IN_PROGRESS');
INSERT INTO lists_students (user_id, course_run_id,status_student_id)
VALUES ('11','6','TRAINING_IN_PROGRESS');
INSERT INTO lists_students (user_id, course_run_id,status_student_id)
VALUES ('12','6','TRAINING_IN_PROGRESS');