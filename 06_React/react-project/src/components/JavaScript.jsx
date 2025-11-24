import React from 'react'

const text = "Hello, jsx";
const num = 100;

const loginUser = {
    name: "홍길동",
    age: 22,
    gender: "남자"
}

const numbers = [1, 3, 5, 7, 9]

const url = "data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEAAkGBxISEhUTEhIWFRUVFxgVFxcXFxUVFhgYFRgXFhUXFxcaHSggGBolHRcVITEhJSkrLi4uFx8zODMtNygtLisBCgoKDg0OGhAQGi8fIB8tLS0tLS0tLS0tKy0tLS0tKystLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tLS0tN//AABEIAOEA4QMBIgACEQEDEQH/xAAcAAABBAMBAAAAAAAAAAAAAAAGAAQFBwECAwj/xABHEAABAwIDBQUGAwcABwkBAAABAAIDBBEFITEGEkFRYRMiMnGBBxSRocHRQlKxIzNicpLh8BVTc6KjsvEkNDVDVWOCwsMW/8QAGgEAAgMBAQAAAAAAAAAAAAAAAAECAwQFBv/EACgRAAICAgIBBAEEAwAAAAAAAAABAhEDBCExEhNBUWEUIjIzQgVxsf/aAAwDAQACEQMRAD8A3pKYvPIDVSkkjY23Js0JOc2NtzYNAQfiuJmU8mN0H1K8wk5vg7zYsXxV0pP4WDQfU9UJ4liu9drNOJ5/ZaYriO/3W+EfNRi7GtqqP6pHNz7F/piJJdIIXPcGMaXOcbAAXJPQKw9nPZ+G2kq8zr2Q8I/nI8XkMvNbbMlAXg+BVFUbQsJGhecmDzP2R3g/s6hZY1DzK78re4z7n5I8pKCwAa0MaMgAAAB0AT+KmaOFyk2FELRYXFAw9lEyJoF3EADTiTqVASQmpk7V5swZRt/+x6lTW01YXuFOw5eKQjlwb9fgm7WgAAaBNA2N20TBzK6tgaPwhdEkyIP1O1NNHVClIO8SG7wDdwOdo0m9+XxCn7dFRuLyuNbK5xz7d2Z4WfYfKyvOyi4ytUyVqujnJA1wILRn0Ue6laWA27zD5XtkfkpVNG5SEcHC/qMipERpUYdfdlieQ9nebyPEtRJDCJog/da9rhmDYi/EEFQ9L3S5nI3HkU6wWr7Gfsyf2cunJr/pf7IaGiKxjYOlluWtML+bPD6sOXwsgLHdj6mmu4t7SMfjZnb+ZuoV9yQh2oTKeitpmOSinQ6PN6StjaXYaGe74bRS65DuOP8AE3geoVY4jh8sDzHKwscOB0I5tPEdQpJ2I5U87mG7Tb/OPNT1BirX911mu+RQ4kqsuGORF2LNLH10WRhmLuis13eZy4jy+yIu5K27TccCqsw3Fy3uyZjg7iPPmEUYbXuiO803adRwIXGza8sbOpjyrIrRN1ERabFaRSFhuPUc1JwzMmZdv9wUwnhLTYow5njlYsuNZI0x776zqko2yS3/AJy+DF+D9jPG8T7U7rfAPmeaDMZxC92NOXEjj0TvGK/sxut8R+QQ9dR0tf8Asyzazf1iYXajpXyvbHG0ue42AHFaRROc4NaCXOIAA1JOgCuHYvZYUrLuF53jvO13R+UHl9V0WznmNi9lBSt3nWfM7xOGjR+VvTmeKNaekDczmVtTwBo6ruojMJvX1QijdI7Rov5ngPjZOQhTbeuaNyJzg1v7x7ibAAZC5+KKGMMOa5wdI/xPO96LpXV0ULd6WRrBzcQPhzQv/p+prJPd8KhLyMnTOFmNGl88gOp9AijA/ZHFvCbEZn1UpzLblsYPL8zviB0Q5KPYlFsGptuWPduUlPLUv/haQP0Jt6J5DSY/P4KOKBp0MjhvD4uv/uq3MPw+GBoZDEyNo4MaGj5ap0q3m+C1Yvkoep9j2IzvdLLNTNe83dYv18gyymnbD463wVsD/MW//NW6koesyXpIpqeh2gg8dLFUNGpic2/wDgf91Rku2QZIwVVPLTPBz32m3W1wD8lfIXCtoopmlk0bJGnVr2hw+BUlm+SLxfBV8OIRSuZJFI17TdpLSDa+YuOC74jBvMNtRmPMLvtB7Jadx7WgkdSSjMAEuiJ8tW+mXRDL8aq6CQQ4pDYE2bUMzY7zI1/XorlJMrcGiyMCru2ha8+LR38w1+6f2QhshXNEpY1wdHKN9hBuCeh/zRTceMjec2Qbha7dve46X5JOIWPaimDvNDu0GBRVLOzmbpm1w8TTzafoikG+YzWssQcLH0KAPO+0OAy0cm4/Np8Dxo4fQ9FF2V847g7J43QytyOh4g8HNPNUpjeEyUspik4Ztdwc3gQpJioj1J4XiZYd12bf0UYkozgpqmShNwdosDDa4xODm5g6jgQislsrA4HIjLoqtwTELERu0Oh5dEYYLiHZu3XHuO+R5riZ8LxyOvjyKcbRL+5O6JKTuOaSz+bJlI1Exe4uOpXJJTmx2C+91AafAwb8nkDk31P1XpUklSOFbfLC/wBnOzW60VUo77h+yB/C0/itzP6easyjg3Rc6lN8PgGtrAZAKQUWNGUkk2xPEI6eJ80rt1jAXE/QcydLdUhnHHMZhpIXTTu3WN+LidGtHElVzhWzlTjs5qqnegoi4bjPxSNbkA3p/F8E62bweXHan32sBbRRuIhhP47c+Y/MeOmiuGNgaAGgAAWAAsABoAOCjOfj0TjC+xphOEw0sbYqeNsbG8ANepOpPUp6kkszdl64EkkkkAkkkkAJJJJACTbEaCKeN0U0bZGOyLXC4P8AfqnKSdgUvtFsdUYRIKug3paZrg58JJL4wNSObeuo431U0zGIKvcqIHXbKNx7TbeY8cHjnb4qziFT+3+x8lDIcQoGnsr71RA3QcS9o5fp5LTjyXwyieOuUF+Cz7p7K98rhTIKDtnKozCGeO0kbzbebq08WvHAhGKsZWcqmLeHXgg/a/Z8VcJZYCVmcbuv5T0P2RqmdfB+IeqVjPNskZaS1wIc02IOoIyIK1R37TcEDHiqYMnndk/m/C71GXmBzQIpJkTIKJcJrO0ZY+IZHqOBQ0F3op9x4dw4+XFU7GL1IGjXy+Egw7d35j8SkmnvjPzBJcj0X8HS9WPyCSt/2c4V2VM1xHfm7552/CPhn6qrcFoDPPHEPxuAPkM3fIFX/hUQBFhk0WHTgPku6zjIkmNAFuS2WBkldQJGVWWNPfjOIigiJ90p3b1Q8aOLTYi/n3R13jwRN7RdoPcqN72m0kn7OPnvOGbvQXPwT72X7Ne40TQ4ftprSynjdw7rfQfO6UnSscY2wqo6VkTGxxtDWMAa1oFgAMgAuywSldZm7L0jZJRGP7R01EwOqJN3eya0Aue48msGZQ872jsGZw/EBH/rDTu3bc9dEKEn7A5JBwkonZ/aOmrWdpTSh4GTho5p5OacwpS6TTQ07M3SutUrooDdJa3XGtrY4WGSV7Y2N1c9wa0epQlYDhJB59p2FB2770PPckLf6g2yIsLxeCpbv08zJW82ODredtPVNxa9hWh8tXtBFiLg5EHMEHUJXS3lEZT9bTOwLEA9v/h9Y61s7Qv+lterf5VZIcDYg3BzB/RLavA2V1LLTv8Axjuu/K8Zsd6G3pdBPsvxZ74X0k+U9I4xuB1LASGnraxHoFrhLyiZ5RphutXNuLLKV0wB3G8NbNHJA/RwI8jq0j1AKoaogcxzmOFnMcWnzBsV6MxJuYd6fZU97S8O7OqEoHdmbc/ztyd8RulSRFggs3WElIiZuksJJUiXkwz9l9FvVD5SMo2WH8z8v0B+KuGhbZvmq99mVNu0rn8ZHk+jbNH6FWPEO6PIJSEjqktUnFRJexXOMxjEMdgpTnFSN7WQcCRZ5B/4Y+Kt5VV7Gm9vUYhWnPtJdxp6El5+W58FaiqyvmizGZKHNscdkpxFDTtD6qpf2cDToPzyOH5WjNESr6XEQMSxOsIv/o6jDIgdA97TI63Umw9VHHHyZKcqRE7YY9T4MNyEtqsTeP2tTJ33R3z0OTejBYW1UFsZ7Y6yOdra6QTwPNnHda18dz4hugAgcQR5IO2VwuOvqne91jKdpu98kjhvOc46NByLic1BVrGNke2MlzA5wYTqWgkNJtxIstVGY9H+0HCRSbuL0QDZIi0ztZYMngcQHEgZbwBBB+wRhTTtkY17Tdr2hzfJwuFAQtts8BN/6d376/uOPyQ3hO1pgoaClp4veKySni3Yr2axm6LSSu/C22fVVZI2W45UWQsXTLB2ziFvvL2PmzLzG0tZcnINBN7AZX4p3dZ2Xm6CsIw9mL1E1TVd+kpZnw08Jyjc6PKSeT8+eQByARkVWFBM9uzdc2O/aRyVDH21AM13/wC4SrsK9yrKyI229rjo5nU+HRQNgjO7vmMO7QjI7rfCGXuNM9VGbM46K2S8LI6PEmguifCNyCqsCTBLFpvEDIjigHZ51OKmI1bXOp98dqG3Dt062tY5a5ck4xGoip610lE4mKKbfgdnfda7eZrn0zWgoPTGyOPtrqVk7W7pN2vZxa9uT259fopm6AfZ3UAVmJRMG6x0kVU0cveY98gfJHqxTVM1Rdo2uqr2vi9wxqmq25RVg7Gblv5Nuf8Ahn0KtJAXtpw/tMNdIPFA9krTyz3XfJ3yUsT5oU1aCdZUfgVb29NDL/rI2O9S0XT9XlKOdUy7Sq99pdFv0m/xieHeju6f1CsUlDWO0vaQzR/mY9vqRl87KSEyiEkgkpERJJJIAunY2DdpKdvNgJ83d4/qjFoQ7gke6yFvJjB8GhEQKrY0ZUJtTj9PSxO7WZrHvY/cafE47ptYDO17Zp/i+Isp4ZJnnuxsLrcTYXsOpQPsrs373S1GJVo7SeeOXsQ4XbEwNcGlo58unUo65Y0THsKgDcNLuL5nn4BrforDJVeew6W+GAflmkHx3T9VYG8qMn7mXw6NlWstC59fjFDvWfX0rZYL5BzmNLSL+d/QFWQChnbTZl1WI5qeTsaunO9BJ14sd/Cf8uLhPHJJimrR5mrKV8T3RyNLHsJa5rhYgjUEKa2H2ZkxCqZAxp3bgyu4MjB7xJ4E6DqVbGJY/TyWbjmDv7Zgt28Ue/G/qHtIIB5XKcw7cxRRGPB8LeMrl74xBCy2rnuv3ra5kLTZRQ79t+0bKWh9zjIElQAzdGrYWeI+tg0eZW/so2fEFIyokF56loe5x8QjtaJg5ANDTb7Kl6qkrMQbV4hM8vEVi95vZxLg0Mj5NAN+g816Uwlw7CIt8PZst5bosqsrpFmNcjtJYuldZi42QPgcjaLFamimA7DEbzw3HdMhFpoz1Ofy5qZ26qSzDqtwNiIX2PIkWHzIQlR4lDi8LaOta6mrGNZLE69iTYFs0LuNxYlvnyyuxWlZDJzwDG3HsdqYZHSUIM8JNwwfvYweFj4wOYz0yQVhGyFbUVDKcU8rHOcAS+N7Qwfic4kZABXfT4zjtEBHLSMr2NyE0cgjkI4b7TqfT1XGtrsbxEGEQNw6B1xJI5+/MWnUMtoT5DzV/kinxN9gWtfX4lPEbwh0NNGRo73dm6T10HxR5dRmz2Cw0UDKeEWYwanVxPic7qVI3WWb8nZoiqVG11CbcU/aYfVs5wSEebWlw+YUzdMMffalqL6djL/yOSjwxvoDPZdXtkw+Bu8N9jXNLbjeAa9wBI1tZFyo3DKAUmH0eKQgiRtQ9kxBcQ6PeLQCNBkCOt1d8UocA4aOAI8iLhamjNZuVE1bbPKlbqMr/H6BCY2UDicO5NK38sjx8HFNlKbUNtWTj/3HfPNRamQEkkkgC0RtxEzcbEwvcABc91tw23mU0rdsKuTR4jHJgsf6jmguj8QRVhuCvksXAgfM/ZKgB/aapkdC4ve517Zkk8RzV64U+GGgg7R7I4+xjbvOcGtG8wC1zlmq72mwRgoJmtbmG7wtmbtId+gKLNlIqfE8IgZO0SN3BG8Zgh8XcuDqHaG/VVzXBOBBew2YNbWU29fs5g4cQQbsuDy7nzVoql9kaB2E417q514qhhax2lwe9HfqC0t/6q51VkXNlsOjKSwkqyZtdAPtexR4p4qKD97WPEYA/ICN70JLR5Eo8uq4w/8A7ZtBNIc2UMQY0cA92Vx8X/BWY+7Iy6Cei2Vijw80DfC6Isc7m9w7zz13jdRfszxomI0FRZtTR/snNOrmN8D28xaw+B4ozQvtbscyrc2eGR1PVx+CZnEDRrxxCad8MOugqusqv46raGEbjoKWptpIH7hPmLjP0SfR47V92WaCijOvZXfLbiAb5fEKPp/YeRj2gV/vsrMJp3XdI4OqXNz7KJhBINtHHLLyHFSu2+ybaqBpg7lRTgGneDYgsGTCeRsPVSGy+zFPQRlkIJc7OSV2ckh5uP0U0E/KuEFX2DWwG05rqa8g3Z4j2c7dCHt424A/qDyRNdVzWxmgxuKRgtDiA7OQcBK3Q+p3fi5WKlP5CJm6S1KyokjKgNvqrssOq3afsXtHm8bo/VTxVd+2/ENyhZCM3TytFhqQzvH57o9U4q5Ck6QwoKWKTZ80u+wze7Oqez3hvjvmRri3UD7qd9n1b22HUztSGbh84yWfQKF2V2bGH4XU1U4PvElO8u3syxm6QyMX46X9BwWnstreyooo5BYOL3Nd5uJzWmPuUP2D8KOxFwDvQKOxna+CC4b+0eODfCD1cq/xDEamsqGvcbMY5pAGTRukHIcT1RQmwf2t/wC+1H+0P6BRKe43P2lRK/TekcfmmSkiIkkkkwDTZrBP3cj/AMViByvx80fxxhuiFNl5t6mi6At/pJRYw3AQIy5txY6HIoMwfFZMDqJGvjdJQzO3g5tiWOOXlcaEcQBZGa1ewOFiAQdQRcJNWNOiuPaJtQyuqop6ISH3Zm8Xltt0h+8DbgArr2YxllZSxVDbd9o3h+V4ye30N0IzQRMY5oY0NeLEAAAg5G9kKeyvaRtJVyUTn70Erz2TzewkGQ9HDLzA5qucOCyE+S7UrrS6V1mLzdAXsrgN6+Z2stXIL8bMJt83FHd01oaKOFpbG0NBc55A4ued5x9SVJOk0RaHV1H4pj1LTWE9RHEToHuAJ9NbJxX1BZFI8C5Yxzrc91pIHyVTbMYPFPEKqoaJ5p7vc5/etcmwAOQtZSirVstxY3kl4otjDsShnbvwyskbzY4OHrbRMcZ2qoqQ7tRUMY6193Nzv6WgkKt8SweSlcKnDB2co7r42+B7Tlmy9jY2Ke4Js9HE3fmAlnf3pJH2eS45kZ6D7JtJFkdTI5OL4+yxMHxumq2b9PMyUDXdObf5m6j1UhdUxtJTigcyvpf2b2PaJGtybIxxzBboeX/RXDDKHNa4aOAcPIi6UklyiqcHCXjIZY1g0VSYTJcGCVszCPzNvkehUndaXS3lBsibrF1rdYSA3uqX2y2oiONQvkDn09E5rHFouA83Lnejt3LjuFWPtvtE2gpHzE98jdibzeRl6DU+SA9kcBDaV3vDQ99Qe0kDhfxZgHrx8yVfijfJXkl7Dj2mbXQ1ULKKikE0lQ5u8WE7rWg3sTzJ1HAA3UrSULWQshGjGNaPQAXXDDMCpqcl0MLWOOV8ybcrk5BSSuSopbsHJsCYZbnK/DgTzXZ0bWbxA0B+Sl6qO7eo4oVxeuLYJSfFulv9WQ/VMRXsz95xPMk/E3WizdYQAkkkkAGmw8943s/K7e9Hf3HzRtBPZgvwyVYbJVW5OAdHjd9dW/VWRh8mZCAH7ZAdCk99hcpu+mzu02KbyTEkB2g1sgRHbT1Dm0k8vHc3W9N6zb/NVyKLehZu5OADgRrfXVWPtkQ+hnA4Nvb+Ug/RAVA68bPIfLJVZW0rM2zNwSa+S1fZjtmKuMU87rVMQsb5do0fiHNw4j1R4vNs0b2PbNC4slYQ5pGRuFbmwW3kdc3spbR1LR3m6B9vxMv+nBVNXyjXr7CyINrpXWiSgajL2ggg5g5H1yKq11JU4a5tMIWzRPdIYHNka1+7m8tc13LPPRWjdBXtBgkjfT1rWl7IN9koaLkMkt3wOhaLqcX7E8c/CSadEDJtHK3I0FTfoA4fELk7aCsIuzDn/wDzeG/Kyl6HGqeYb0czCPMA+oOYTLH8fbG3s4j2k8ndijYd4lzsgctAFJL6OlN1Hy8/+DTBMGqcY7OWYsio2vJ7Np3nyOYbFp5D7nJW1kMhkBooPYzBjR0cUDs3gFzzw33nedboCbeim1CT5o5Tk5O2bXWVosqIGy1e8NBJNgBck5AAZklJVH7Sds/eHGhpH/s72nkBydbWNp5czx0TUbITmoK2D23mPHEqh5YT7vAHNj5OPF/rb4AIv2JrnTUcTnG7gCwn+QkD5WVflgjjIAyAP6Iv9nbi2iblcue8j42+hWjHKzBizPK2wuuuUlSB1PJcyx7vEbDkF0ihAVhcNKxzy3M7oPBBe28gDWMGrjc+Q/ujPEJLutyVZbRVvazuPBvcHkOPxQMigks2WEAJJJJAG8Mha4OGrSCPTNWfhtYHtbI3iAfuFVyKtjcQ1hJ/ib9R/nVAFgTTgNuOOi0pmWGepzUfFNvOazlmpYIAaVtA2RjmnLeBafUWVV4aCwvhd4o3FvwNv881b6rzbzDjBO2qYO7J3ZOjrZH1A+IUJxtFWaHnBoY3TSppLkPYSyRuYcDY3GhuMweq7OkAbvcMvgVsFlTcTkwcsbtBlsn7T3MtBiIOWQnAvf8A2gH/ADD4K0KSqZK0Pje17To5pBB9QvPcsTXCzgCsYbPU0jt6kndHzbe7T5tORU7jL6Oph3k+JcHoolK6qbC/avKwhlXS7xOW9Ccyf5Dr6FGNDt1RyamWI8pIZW/EgED4ocGblOMumd8S2Kw+cl0lLHvHMlt2EnrukXTjBdl6OkO9BTsY7Tezc63RxuQpKnnbI0PY4OadCNF0UXJk0kbXSumOJ4rBTND55WRNJsC82BOthzKH6j2k4Ywf943zyYyQn/lshJsG0gvXCtro4WGSV7WMbmXONgqyxT2rPfdtHSn+ebTz3Gn6oLxGeoq3dpVzOkI0boxvRrRkFLxrsz5NqEPcJtrvaFJW70FHvRw6PlOT3g5WA/C35nohilp2xizVsxoAsBYLSGYOzGmnmlJ2uDk58883+jjis27GeZyCs3Z2j7Gmij4tYL+ZzPzKrzAaH3uraNY4u+7kSNB6n9FZtI+7R0y+CvxxpGzXx+EOfccXXKpkAat1HVk28ctArC8iNoMQ7GFzge8e63zPH0zKrolS+02JdtLZp7jMh1PEqIQMwkknWG0vaPA4anyUZSUVbJRi5OkN93oUkX9i3kFhZfy4mv8AGkB6608zmODmmxabhauYQSDqDZarWnZjaosPB60S2lbyseh4hEsEu8LqqsBxUwPz8DsnD6qwaOoGTgbg5+YTES4K4V9GyaN0cgu14sfuORWzH3FwtroAqfEaV9HIYJgXMPgcPxDp10yWtIXsPZysew23mb7S0lvDI/5kjvbCGORsEcgykqYmX0LQ53eseBtcKf2gwGnxOlAhkBkgvHHLe5DmZOY46kGwufIqqaRVLXjNMrFJNnukhkdBUMLJG5G+h634g804us7i12cnJilB0zSaEO19DxB5gogwXbqtpbMktUxDIbxtIByDuPrdQN0k1NosxbE8fRZVH7U6F370SwniHMLvm2/6LvL7T8NAyle48hFJf5gBVaRzWAwch8An5R+DYv8AIfQWY/7R/eW9nDRNcNQ6oDXAHmGaX9UG+67zzJKQ555Na1o5ANaAAE4SCbn8GfNtzn1wbLF0rLk9z3ObFC0vled1rRrf6KKTZmhCU5UhpX1QuIwbX8R5BbOqLlsMA3nus1oCtbB9jTSUUjGMjmqpW94yAFm9wGY8Lb36lDWw+EMhMxcAZ2Suie7LdFrGzOQNwr4wTOr+MopWTOzODNpIQzV57z3c3Hl0GgT2mNnOHJdgUwln3ZHDiQrrLhxV1FshqhLarFezZ2TT33jM8m8fU6KQxnFGwMLnZuPhbzP2Vf1M7pHF7jdzjdIDkslYSQMyBfRE+E0fZsz8Tsz9Ao/BKG57RwyHh69UXYJQdq+5Hdbmep5Lm7mdftR0NXDX6mM+xdyPwWEcdm38o+CS5fqm+iq8dor/ALRvDxfdQbkdVlMY3Fjh9iOaFcWw/szvNHcPyPJdfUz2vFnO2sP9kRwU7s9jfZHckP7M6H8p+yglm63mEtKlqrZg3BUmyQHRVhguNuh7rruZy4t8vsjSjrWvAcxwIKAJPFMOjqIzHICWkg5EggjQgjQqAhNXSxSUVMwsZJLvNqN7Nkbw3eAGu/cHNTzKreFhkeq51EjiACNDqlVhYPw7KyTPldWydqS1rI3g9+zL2cTzta4QxjFJLRSCN37RhzY7S44jzHJWe2ZvNNsWw2OpiMcguDmDxaeY5FNxT7K5JS7KzZiTON2nqF2bVMP4x8V1xLZ2op73Z20Y/E0XcB1GoUQWxHgP0UPx4v3MstaBLh4OhHxWb9VG4XhPvErY4r6gvdfJreJ8+SMjsFTHSSUerfsoPB9kfw18g4+Zo1cPim78TjGhLj0C67Q7KupAJC4SRl27oQ4E6XHLqo9s0bRlbyAzU4a8fdk1qxX2bTVkjgSLMbzOqK9i4K2kb28NPDI6UXBkJEgbyGdgDqo7ZfCG1BE0xvG1xAjHEtse/wBM9FYUc98g02U/GK4RpxwUVwiFmrMWqagSBxomNZuFu+JGuNzdzW889TpZS2F4c2Bm6CXEkve93ie92bnHzKcveAM0zmrODUUWtjiepA01Q1iGJtic57zc6AcXFYxfGmQi3ik5cup5IKq6l0ji55uT8PRAjevrXzPL3nPgOAHIJskkgDKfYXh5kNz4R8+i1w2gMpucmjj9AiqkpiSGRjoB9Vi2dnwVI2a2v5O5dHSipDI4Mbl+gARjTQNjYGgWA/y654ZQtibbifEef9lxram/dGg1XGk3NnSoc++BJRl+qwl6Y6Y/xSgEreTh4T9PJCFVTWux46EI0pKnfyOo/wAuuOJYY2YcnDQ/QohJxZFoqrEsNMeYzb+nmo9HNXTOYSx7ehvoR9QhzEsJLe8zMcRxHlzC7OttKSqRz8+s1+qJFWTmhrnwuux1uY4HzCbrVbjEGuF4/HLk7uO6nunyKmZZyGniqxT+jxiaLwuuOTsx6ckAWLTyxvaCRYpzHC0Zi/xQdRbSRnxtLD0zb9wpmmxBj/BID5H6IFRPAoExPYmQyPdEYi17i4B+8HN3jcjIZ8UUtqnDqthXHkEAhtszs8yka6zt577bztBloGjgMyppMffh+X5rHv38KAO1fSsmjdHILtcLEfUcigufYiZrrRSRlnAvFngdbDNFjqx3Jcpak8Tb5IBHLDMPZSsZEHXtcucdXOOpsn76wcEPVmLwscCX3I4N739lEVm073ZRt3epzPpyQMKayuawb0jg0dfoOKF8U2kc67Yu6PzfiPkOCgpp3PN3OLj1N1zQBkm5udTqeJWEl0hic42aLlJtLsEm+Ec1J4dhRfZz8m8uJT3D8IDe8+xPLgPuiDD8OfKbDIcXcB9yufsbdcRN+DW95nCipC4hkbfhkAOqLsMw9sLcs3HV308l0oaNkTbNHmTqfNcKur4N9SuW5ORvXBmsquDfVcaGlMrt0ep5LFHSOkdZvqeSIwxsLN1uvzPUrbq63ly+jNsbCgqXZx/0HH1SWnbO5lYXR9CHwYPyp/JAZtPIj4qUpKoOyOR/VSWJ4aJe8Mn8+B8/uhuWJzDZwIIXKz6zgzp4s8ciJOtomSizh5HiPJCmJYY+I3ObeDh9eSIaastk74p9cEcwfVZLcWWtlaVuGtkzHddzGh8woOroXx+IZcxmFZ9dgIdnGd08uH9lA1dI+PJ7SPmD6rdg3JR4fJmy68Z89MBbLCJanCY3Zjunpp8FFz4RI3Szh01+C6OPZhP6MU9acfsj0gVs+Mg2IIPVaK9NMoaa7HUOISt8Mjh63/VOWY9UD8d/MBRiSYiX/wD6Kfm3+lI7RT82/wBKiEkASEmMTn/zSPKw+iaSzvd4nF3mSVzWECFZZWE5goZH+Fh8zkPmouSXZNRb6Q2WWgk2AuVM0+B8Xu9B91K0tIxmTW5/ElZsm3CPXJpx6k5cvghaTBXOzf3Ry4/2U5S0zW91jdfiVMUeCyPzd3B11+CIKHDo4vCM+JOZ/subm25yNuPDCHRD4bgJNnS5fw8/Pkp6zWDQABcqisDb2zKjpZS43JWWpSLTvVVRdkMgs0FA6U5ZNGp4eXmneHYO59nPybrbifspiSVsY3W2y4Lo62pfMujJn2VHiPZgNZCzdb/c9SmD3k5lJziczqsLqqKSpHMbbdsSSzZZTESlL4QonaXVnkkksu3/ABmzU/kIMp/hvh9fuspLhZDpjtM8Y/dO8ispJREBjVlJJaYh7DLE/ChqTVJJdbX6OZn7NEkklpMwkkkkAJJJJAElhOoRIUklg2TfrmpUvgX7z/OqSS50jo+wTrWo8BSSWaXZAhnJxh37xnmkktOPtCl0F7tFDzeIpJLux6OJLs0SSSUyBskkkgD/2Q=="

const userList = [
    {
        name: "홍길동",
        age: 22,
        gender: "남자"
    },
    {
        name: "홍길서",
        age: 22,
        gender: "남자"
    }
]

const getImg = () => {<img src={url} alt="빵빵이" width={100} height={100}/>}

const JavaScript = () => {
  return (
    <>
        <h1>React의 JS</h1>
        <h2>변수 표현 방법</h2>
        <ul>
            <li>{text}</li>
            <li>{text + "test"}</li>
        </ul>

        <ul>
            <li>{num}</li>
            <li>{num + 1}</li>
        </ul>

        <h2>boolean 값</h2>
        <ul>
            <li>{true}</li>
            <li>{false}</li>
            <li>{null}</li>
            <li>{undefined}</li>
        </ul>

        <h2>Object, Arrey</h2>
        <ul>
            {   
                //[name, age, gender]
                Object.keys(loginUser).map((key) =>  
                    <li key={key}>{key} : {loginUser[key]}</li>)
            }

            <li>numbers : {numbers}</li> {/* 배열 그래도 출력(문자열로 자동 변환) */}
            {[<li key={1}>111</li>, <li key={2}>222</li>, <li key={3}>333</li>]}
        </ul>

        <h2>태그 속성에 값 넣기</h2>
        <ul>
            <img src={url} alt="빵빵이" width={100} height={100}/>
        </ul>

        <h2>조건부 렌더링</h2>
        <ul>
            <li>{num > 10 ? "10보다 큼" : "10보다 작음"}</li>
            {num !== 10 && <li>num은 10보다 큼</li>}
            {num === 10 && <li>num은 10보다 작음</li>}
            {num === 10 || <li>num은 10보다 작음</li>}
            {num === 10 || <li>num은 10보다 큼</li>}

            <h3>삼항 연산자</h3>
            <li>{1 + 1 === 2 ? "참이다" : "거짓이다"}</li>
            
            <h3>AND 연산자</h3>
            <li>{1 + 1 === 2 &&  "AND1"}</li>
            <li>{1 + 1 !== 2 && "AND2"}</li>
            {userList.length !== 0 && userList.map(u => <li>{u.name}</li>)}

            <h3>AND 연산자</h3>
            <li>{1 + 1 === 2 || "OR1"}</li>
            <li>{1 + 1 !== 2 || "OR2"}</li>
            {userList.length !== 0 || userList.map(u => <li>{u.name}</li>)}
            
            <h2>함수 호출로 태그가 반환되어 올 수 있음</h2>
            <ul>
                <li>{getImg()}</li>
            </ul>
        </ul>
    </>
  )
}

export default JavaScript