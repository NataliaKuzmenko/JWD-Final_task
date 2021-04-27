# Web application of the educational center
____
Designed for the work of teachers and students with courses.
## The following roles exist in the application:
____
1. Admin
2. Student
3. Teacher
## User capabilities depending on the role:
____
__- Unauthorized user:__

    * view general information about the company (sections 'Main', 'Contacts')
    * view available for register the list of courses (list has pagination)
    * view detail of some course
    * register
    * log in
    * localization
    
__- Admin:__

    * view general information about the company (sections 'Main', 'Contacts')
    * view the list of all courses (list has pagination)
    * view detail of some course
    * view students on the course(change student status, add student mark and comment)
    * view the list of all users (list has pagination)
    * change user role from 'student' to 'teacher'
    * view profile
    * edit profile( add/change name and surname, change email, upload photo)
    * localization
    * logout
    
__- Student:__

    * view general information about the company (sections 'Main', 'Contacts')
    * view available for register the list of courses (list has pagination)
    * view detail of some course
    * register on the course
    * view profile
    * edit profile( add/change name and surname, change email, upload photo)
    * view courses registreted and their result(course status, student status, mark, comment)
    * cancel course
    * localization
    * logout
    
__- Teacher:__

    * view general information about the company (sections 'Main', 'Contacts')
    * view the list of all courses (list has pagination)
    * create a course
    * view detail of some course
    * edit course if he is author of the course( edit course title,description, dates, format, status)
    * view courses, that he is teaches
    * view students on the course(change student status, add student mark and comment)
    * view profile
    * edit profile( add/change name and surname, change email, upload photo)
    * localization
    * logout
