// AND condition 
let val:number&boolean

// type alies -> custom name to type
type emp={

    empName:string
    empID:number
} 

type stud={
    stdName:string
    stdID:number
}

type clg=emp&stud

let details:clg={
    empName:"Dilip",
    empID:56,
    stdName:"Kumar",
    stdID:78

}

console.log(details , typeof details)