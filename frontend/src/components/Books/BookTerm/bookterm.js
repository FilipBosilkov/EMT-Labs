import React from 'react';
import {Link} from "react-router-dom";

const bookterm = (props) => {
    return (
        <tr>
            <td scope={"col"}>{props.term.name}</td>
            <td scope={"col"}>{props.term.category}</td>
            <td scope={"col"}>{props.term.author ? `${props.term.author.name}` : 'Unknown Author'}</td>
            <td scope={"col"}>{props.term.author ? `${props.term.author.country.name}` : `Uknown Author`}</td>
            <td scope={"col"}>{props.term.availableCopies}</td>
            <td scope={"col"} className={"text-right"}>
                <a title={"Delete"} className={"btn btn-danger mx-1"} onClick={()=>props.onDelete(props.term.id)}>Delete</a>
                <Link className={"btn btn-info ml-2 mx-1"}
                      onClick={()=>props.onEdit(props.term.id)}
                to={`/books/edit/${props.term.id}`}>Edit</Link>
                <a title={"Mark"} className={"btn btn-danger mx-1"} onClick={()=>props.onMark(props.term.id)}>Mark</a>
            </td>

        </tr>
    )
}

export default bookterm;