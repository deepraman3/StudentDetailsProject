const students = [];

exports.getAllStudents = (req, res) => {
  res.json(students);
};

exports.createStudent = (req, res) => {
  const newStudent = req.body;
  students.push(newStudent);
  res.status(201).json(newStudent);
};

exports.getStudentById = (req, res) => {
  const student = students.find(s => s.id === parseInt(req.params.id));
  if (student) {
    res.json(student);
  } else {
    res.status(404).send('Student not found');
  }
};

exports.updateStudent = (req, res) => {
  const student = students.find(s => s.id === parseInt(req.params.id));
  if (student) {
    Object.assign(student, req.body);
    res.json(student);
  } else {
    res.status(404).send('Student not found');
  }
};

exports.deleteStudent = (req, res) => {
  const index = students.findIndex(s => s.id === parseInt(req.params.id));
  if (index !== -1) {
    students.splice(index, 1);
    res.status(204).send();
  } else {
    res.status(404).send('Student not found');
  }
};
