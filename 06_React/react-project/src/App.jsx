
import { useState } from 'react'
import JavaScript from './components/JavaScript'
import './App.css'
import styled from 'styled-components'
import Product from './components/Product'

const products = [{
  product_id: 1,
  product_name: "삼성 갤럭시 S25",
  price: 2000000,
  color: "블랙",
}, {
  product_id: 2,
  product_name: "아이폰 16",
  price: 1800000,
  color: "실버",
}, {
  product_id: 3,
  product_name: "LG 그램",
  price: 2200000,
  color: "화이트",
}]

const Table = styled.table`
  width: 100%;
  border-collapse: collapse;
`

const Th = styled.th`
  background-color: #8a8a8a;
  color: white;
  padding: 12px;
  border: 1px solid #afafaf
`

function App() {
  /* const [count, setCount] = useState(0) */

  return (
    <>
      {/* <JavaScript /> */}
      {/* <Style /> */}

      <Table>
        <thead>
          <tr>
            <Th>번호</Th>
            <Th>제품명</Th>
            <Th>가격</Th>
            <Th>색상</Th>
          </tr>
        </thead>
        <tbody>
          {products.map(p => <Product key={p.product_id} product={p}/>)}
        </tbody>
      </Table>
    </>
  )
}

export default App
