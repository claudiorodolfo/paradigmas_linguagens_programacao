# Python

import asyncio

async def tarefa1():
    for i in range(3):
        print(f"Tarefa 1 - execução {i+1}")
        await asyncio.sleep(1)

async def tarefa2():
    for i in range(2):
        print(f"Tarefa 2 - execução {i+1}")
        await asyncio.sleep(2)

async def main():
    await asyncio.gather(tarefa1(), tarefa2())

asyncio.run(main())
