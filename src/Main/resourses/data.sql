CREATE TABLE students (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL,
                          password VARCHAR(255) NOT NULL,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE teachers (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          name VARCHAR(255) NOT NULL,
                          email VARCHAR(255) NOT NULL,
                          password VARCHAR(255) NOT NULL,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE courses (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(255) NOT NULL,
                         description TEXT,
                         teacher_id INT NOT NULL,
                         FOREIGN KEY (teacher_id) REFERENCES teachers(id),
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE students_courses (
                                  student_id INT NOT NULL,
                                  course_id INT NOT NULL,
                                  FOREIGN KEY (student_id) REFERENCES students(id),
                                  FOREIGN KEY (course_id) REFERENCES courses(id),
                                  PRIMARY KEY (student_id, course_id)
);

CREATE TABLE lessons (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(255) NOT NULL,
                         description TEXT,
                         course_id INT NOT NULL,
                         FOREIGN KEY (course_id) REFERENCES courses(id),
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE tasks (
                       id INT PRIMARY KEY AUTO_INCREMENT,
                       name VARCHAR(255) NOT NULL,
                       description TEXT,
                       deadline TIMESTAMP,
                       lesson_id INT NOT NULL,
                       FOREIGN KEY (lesson_id) REFERENCES lessons(id),
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);



CREATE TABLE logs (
                      id INT PRIMARY KEY AUTO_INCREMENT,
                      name VARCHAR(255) NOT NULL,
                      message TEXT,
                      date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                      stacktrace TEXT
);
INSERT INTO students (name, email, password) VALUES
                                                 ('Student1', 'Student1h@gmail.com', 'password1'),
                                                 ('Student2', 'Student2@gmail.com', 'password2'),
                                                 ('Student3', 'Student3@gmail.com', 'password3'),
                                                 ('Student4', 'Student4@gmail.com', 'password4'),
                                                 ('Student5', 'Student5@gmail.com', 'password5');

INSERT INTO teachers (name, email, password) VALUES
                                                 ('Teacher1', 'Teacher1@gmail.com', 'password6'),
                                                 ('Teacher2', 'Teacher2@gmail.com', 'password7'),
                                                 ('Teacher3', 'Teacher3@gmail.com', 'password8'),
                                                 ('Teacher4', 'Teacher4@gmail.com', 'password9');

INSERT INTO courses (name, description, teacher_id) VALUES
                                                        ('Mathematics', 'Mathematics course', 1),
                                                        ('Physics', 'Physics course ', 2),
                                                        ('Chemistry', 'Chemistry course', 3),
                                                        ('Computer Science', 'Computer Science course', 4);

INSERT INTO students_courses (student_id, course_id) VALUES
                                                         (1, 1),
                                                         (1, 2),
                                                         (2, 1),
                                                         (2, 3),
                                                         (3, 2),
                                                         (3, 4),
                                                         (4, 1),
                                                         (5, 2),
                                                         (5, 4);

INSERT INTO lessons (name, description, course_id) VALUES
                                                       ('Introduction to Mathematics', 'Basic concepts in Mathematics', 1),
                                                       ('Mechanics', 'Classical mechanics', 2),
                                                       ('Introduction to Chemistry', 'Concepts in Chemistry', 3),
                                                       ('Programming Fundamentals', 'Programming using Java', 4);

INSERT INTO tasks (name, description, deadline, lesson_id) VALUES
                                                               ('Algebra Exercises', 'Solve the following algebra problems:...', '2023-06-01 12:00:00', 1),
                                                               ('Kinematics Problems', 'Solve the following kinematics problems:...', '2023-06-15 12:00:00', 2),
                                                               ('Balancing Chemical Equations', 'Balance the following chemical equations:...', '2023-06-10 12:00:00', 3),
                                                               ('Java Basics', 'Write a Java program that...', '2023-06-05 12:00:00', 4);