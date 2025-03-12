# Student Details Backend

This is a simple backend service for managing student details using Node.js and Express.

## Installation

1. Clone the repository:
   ```bash
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```bash
   cd studentDetailsBackEnd
   ```
3. Install the dependencies:
   ```bash
   npm install
   ```

## Usage

1. Start the server:
   ```bash
   npm start
   ```
2. The server will be running on `http://localhost:3000`.

## API Endpoints

- `GET /students` - Retrieve all students
- `POST /students` - Create a new student
- `GET /students/:id` - Retrieve a student by ID
- `PUT /students/:id` - Update a student by ID
- `DELETE /students/:id` - Delete a student by ID
