import { useEffect, useState } from 'react';

function App() {

  let [list, setList] = useState([]);

  useEffect(() => {
    fetch('/api/board/list')
        .then((res) => res.json())
        .then(res=>res.list)//res.list의 list는 스프링에서 보낸 이름
        .then(res=>res.forEach(item=>{
          setList(list=>[...list, item]);
        }))
  }, []);
  return (
    <div className="App">
     <table>
      <thead>
        <tr>
          <th>번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>게시판</th>
        </tr>
      </thead>
      <tbody>
        {
          list.map(item=>{
            return(
              <tr>
                <td>{item.bo_num}</td>
                <td>{item.bo_title}</td>
                <td>{item.bo_me_id}</td>
                <td>{item.bo_co_name}</td>
              </tr>
            )
          })
        }
        
      </tbody>
     </table>
    </div>
  );
}

export default App;
