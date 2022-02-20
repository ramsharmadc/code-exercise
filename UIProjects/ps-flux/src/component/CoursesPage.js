import React from "react";
// import getCourses, { } from "../api/coursesApi";

class CoursesPage extends React.Component {

    state = {
        courses: []
    };

    componentDidMount() {
        this.getCourses().then(courses =>
            this.setState({ courses: courses }));
    }

    render() {
        return (
            <>
                <h2>Courses</h2>
                <table className="table">
                    <thead>
                        <tr>
                            <td>Title</td>
                            <td>Author</td>
                            <td>Category</td>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.courses.map(
                            course => {
                                return <tr>
                                    <td>{course.title}</td>
                                    <td>{course.authorId}</td>
                                    <td>{course.category}</td>
                                </tr>
                            }
                        )}
                    </tbody>
                </table>
            </>
        );
    }

    getCourses() {
        // courses = [];
        return [];
    }
}

export default CoursesPage;